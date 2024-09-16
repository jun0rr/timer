/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.jun0rr.timer;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author F6036477
 */
public record Timer(List<Instant> laps) {
  
  public Timer() {
    this(new LinkedList<>());
  }
  
  public Timer start() {
    laps.clear();
    laps.add(Instant.now());
    return this;
  }
  
  public Timer lap() {
    laps.add(Instant.now());
    return this;
  }
  
  public Timer stop() {
    laps.add(Instant.now());
    return this;
  }
  
  public List<Duration> duration() {
    if(laps.isEmpty()) {
      return Collections.EMPTY_LIST;
    }
    List<Duration> durs = new LinkedList<>();
    LinkedList<Instant> ls = new LinkedList<>(laps);
    Instant start = ls.poll();
    while(!ls.isEmpty()) {
      Instant end = ls.poll();
      durs.add(Duration.between(start, end));
      start = end;
    }
    
    return durs;
  }
  
  public Duration total() {
    LinkedList<Instant> ls = new LinkedList<>(laps);
    Instant start = ls.poll();
    Instant end = null;
    while(!ls.isEmpty()) {
      end = ls.poll();
    }
    return Duration.between(start, end);
  }
  
  public static String format(Duration d) {
    return String.format("%dd-%02dh:%02dm:%02ds.%dms", d.toDaysPart(), d.toHoursPart(), d.toMinutesPart(), d.toSecondsPart(), d.toMillisPart());
  }
  
}
