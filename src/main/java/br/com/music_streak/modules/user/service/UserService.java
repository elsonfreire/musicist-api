package br.com.music_streak.modules.user.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.music_streak.modules.user.dto.UpdateUserRequestDto;
import br.com.music_streak.modules.user.dto.UserResponseDto;
import br.com.music_streak.modules.user.dto.UserStreakResponseDto;
import br.com.music_streak.modules.user.model.User;
import br.com.music_streak.modules.user.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
            .stream()
            .map(UserResponseDto::new)
            .toList();
    }

    public UserResponseDto findById(Long id) {
        User user = this.findUserEntityById(id);
        return new UserResponseDto(user);
    }

    public UserResponseDto update(Long id, UpdateUserRequestDto userUpdated) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if(userUpdated.username() != null) {
            validateUsername(userUpdated.username());
            user.setUsername(userUpdated.username());
        }

        if(userUpdated.instrument() != null) user.setInstrument(userUpdated.instrument());
        if(userUpdated.bio() != null) user.setBio(userUpdated.bio());
        if(userUpdated.level() != null) user.setLevel(userUpdated.level());

        User newUser = userRepository.save(user);

        return new UserResponseDto(newUser);
    }

    private void validateUsername(String username) {
        if(userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username is already in use");
        }
    }

    public UserStreakResponseDto getStreak(Long id) {
        User user = findUserEntityById(id);
        return new UserStreakResponseDto(user.getCurrentStreak(), user.getLongestStreak());
    }

    public void incrementStreak(Long id) {
        User user = this.findUserEntityById(id);

        if (user.getLastPracticeDate() != null) {
            LocalDate today = LocalDate.now();
            LocalDate lastPracticeDay = user.getLastPracticeDate().toLocalDate();
            
            if (today.isEqual(lastPracticeDay)) {
                user.setLastPracticeDate(LocalDateTime.now());
                userRepository.save(user);
                return;
            }
        }

        user.setCurrentStreak(user.getCurrentStreak() + 1);     

        if(user.getCurrentStreak() > user.getLongestStreak()) {
            user.setLongestStreak(user.getCurrentStreak());
        }
        
        user.setLastPracticeDate(LocalDateTime.now());
        userRepository.save(user);
    }

    public void resetStreak(Long id) {
        User user = this.findUserEntityById(id);
        
        if(user.getLastPracticeDate() == null) {
            return;
        }

        LocalDate today = LocalDate.now(); 
        LocalDate lastPracticeDay = user.getLastPracticeDate().toLocalDate();

        if(today.isAfter(lastPracticeDay.plusDays(1))) {
            user.setCurrentStreak(0);
            userRepository.save(user);
        }
    }

    private User findUserEntityById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }
}