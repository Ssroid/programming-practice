package org.sunms.designpattern.behavioral.command;

/**
 * 거실 조명입니다. 리모컨이나 명령에 대해서는 전혀 모르고, 자기 일(켜기/끄기)만 합니다.
 *
 * <p><b>역할:</b> Receiver (실제로 일하는 객체 ①)</p>
 *
 * @see LightOnCommand
 * @see LightOffCommand
 */
public class LightReceiverCommand {

    /** 조명을 켭니다. */
    public void on() {
        System.out.println("    [조명] 조명이 켜졌습니다.");
    }

    /** 조명을 끕니다. */
    public void off() {
        System.out.println("    [조명] 조명이 꺼졌습니다.");
    }
}
