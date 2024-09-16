/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jun0rr.timer.test;

import com.jun0rr.timer.Timer;
import org.junit.jupiter.api.Test;

/**
 *
 * @author F6036477
 */
public class TestTimer {
  
  @Test public void test() throws InterruptedException {
    Timer timer = new Timer();
    timer.start();
    Thread.sleep((long) (3000 + Math.random()*1000));
    timer.lap();
    Thread.sleep((long) (2000 + Math.random()*1000));
    timer.stop();
    timer.duration().stream()
        .peek(d->System.out.printf("-> duration: %s%n", d))
        .map(Timer::format)
        .forEach(s->System.out.printf("   format..: %s%n", s));
    System.out.printf("*  Total..: %s%n", Timer.format(timer.total()));
  }
  
}
