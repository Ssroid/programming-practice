package org.sunms.designpattern.behavioral.command;

/**
 * 에어컨입니다.
 * 조명과 메서드 이름도, 하는 일도 다르지만
 * 명령 객체로 감싸면 리모컨에서는 똑같이 {@code execute()}로 다룰 수 있습니다.
 *
 * <p><b>역할:</b> Receiver (실제로 일하는 객체 ②)</p>
 *
 * @see AirConditionerOnCommand
 */
public class AirConditionerReceiverCommand {

    /** 희망 온도 (기본값 26도) */
    private int temperature = 26;

    /**
     * 에어컨을 켜고 희망 온도를 설정합니다.
     *
     * @param temperature 희망 온도 (도)
     */
    public void powerOn(int temperature) {
        this.temperature = temperature;
        System.out.println("    [에어컨] 전원 ON, 희망 온도 " + this.temperature + "도");
    }

    /** 에어컨을 끕니다. */
    public void powerOff() {
        System.out.println("    [에어컨] 전원 OFF");
    }
}
