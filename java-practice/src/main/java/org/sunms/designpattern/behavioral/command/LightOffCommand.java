package org.sunms.designpattern.behavioral.command;

/**
 * "조명 끄기" 명령입니다. {@link #undo()} 하면 다시 켜집니다.
 *
 * <p><b>역할:</b> Concrete Command (구체적인 명령)</p>
 */
public class LightOffCommand implements RemoteCommand {

    /** 명령을 수행할 조명 (Receiver) */
    private final LightReceiverCommand light;

    /**
     * "조명 끄기" 명령을 만듭니다.
     *
     * @param light 끌 조명
     */
    public LightOffCommand(LightReceiverCommand light) {
        this.light = light;
    }

    /** 조명을 끕니다. */
    @Override
    public void execute() {
        light.off();
    }

    /** 실행 취소: 조명을 다시 켭니다. */
    @Override
    public void undo() {
        light.on();
    }

    /**
     * {@inheritDoc}
     *
     * @return "조명 끄기"
     */
    @Override
    public String getName() {
        return "조명 끄기";
    }
}
