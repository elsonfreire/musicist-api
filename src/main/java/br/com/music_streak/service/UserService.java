package br.com.music_streak.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.music_streak.model.User;
import br.com.music_streak.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) {
            return null;
        }
        return user.get(); 
    }

    public void incrementStreak(Long id){
        User user = this.findById(id);
        if(user == null) return; 

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

    public void resetStreak(Long id){
        User user = this.findById(id);
        
        if(user == null || user.getLastPracticeDate() == null) {
            return;
        }

        LocalDate today = LocalDate.now(); 
        LocalDate lastPracticeDay = user.getLastPracticeDate().toLocalDate();

        if(today.isAfter(lastPracticeDay.plusDays(1))) {
            user.setCurrentStreak(0);
            userRepository.save(user);
        }
    }
}