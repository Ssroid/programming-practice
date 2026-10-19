package org.sunms.designpattern.behavioral.command;

/**
 * "에어컨 켜기(희망 온도 포함)" 명령입니다.
 * 명령 객체는 실행에 필요한 값(온도)까지 함께 담아 둘 수 있습니다.
 *
 * <p><b>역할:</b> Concrete Command (구체적인 명령)</p>
 */
public class AirConditionerOnCommand implements RemoteCommand {

    /** 명령을 수행할 에어컨 (Receiver) */
    private final AirConditionerReceiverCommand airConditioner;
    /** 실행할 때 설정할 희망 온도 */
    private final int temperature;

    /**
     * "에어컨 켜기" 명령을 만듭니다.
     *
     * @param airConditioner 켤 에어컨
     * @param temperature    희망 온도 (도)
     */
    public AirConditionerOnCommand(AirConditionerReceiverCommand airConditioner, int temperature) {
        this.airConditioner = airConditioner;
        this.temperature = temperature;
    }

    /** 에어컨을 희망 온도로 켭니다. */
    @Override
    public void execute() {
        airConditioner.powerOn(temperature);
    }

    /** 실행 취소: 에어컨을 끕니다. */
    @Override
    public void undo() {
        airConditioner.powerOff();
    }

    /**
     * {@inheritDoc}
     *
     * @return "에어컨 켜기(온도)"
     */
    @Override
    public String getName() {
        return "에어컨 켜기(" + temperature + "도)";
    }
}
