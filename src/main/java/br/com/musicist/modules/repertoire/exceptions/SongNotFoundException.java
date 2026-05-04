package br.com.musicist.modules.repertoire.exceptions;

import br.com.musicist.common.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class SongNotFoundException extends ApiException {
  public SongNotFoundException() {
    super("Song not found", HttpStatus.NOT_FOUND);
  }
}
