package org.sunms.designpattern.behavioral.command;

/**
 * "조명 켜기"라는 요청을 객체로 포장한 명령입니다.
 *
 * <p><b>역할:</b> Concrete Command (구체적인 명령)</p>
 *
 * <h2>구조</h2>
 * <ul>
 *   <li>필드로 Receiver(조명)를 가지고 있음 → 누구에게 시킬지 알고 있음</li>
 *   <li>{@link #execute()}: 조명에게 {@code on()}을 시킴</li>
 *   <li>{@link #undo()}: {@code execute}의 반대 → 조명에게 {@code off()}를 시킴</li>
 * </ul>
 */
public class LightOnCommand implements RemoteCommand {

    /** 명령을 수행할 조명 (Receiver) */
    private final LightReceiverCommand light;

    /**
     * "조명 켜기" 명령을 만듭니다.
     *
     * @param light 켤 조명
     */
    public LightOnCommand(LightReceiverCommand light) {
        this.light = light;
    }

    /** 조명을 켭니다. */
    @Override
    public void execute() {
        light.on();
    }

    /** 실행 취소: 조명을 다시 끕니다. */
    @Override
    public void undo() {
        light.off();
    }

    /**
     * {@inheritDoc}
     *
     * @return "조명 켜기"
     */
    @Override
    public String getName() {
        return "조명 켜기";
    }
}
