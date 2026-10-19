package org.sunms.designpattern.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 스마트 리모컨입니다.
 *
 * <p><b>역할:</b> Invoker (명령을 실행시키는 쪽)</p>
 *
 * <h2>핵심 포인트</h2>
 * <ul>
 *   <li>리모컨은 "조명", "에어컨" 클래스를 전혀 모릅니다! (import도 없음)</li>
 *   <li>오직 {@link RemoteCommand} 인터페이스만 알고 {@code execute()} / {@code undo()}를 호출할 뿐</li>
 *   <li>실행한 명령을 {@code history}(스택)에 쌓아 두었다가, undo 버튼을 누르면 꺼내서 취소</li>
 * </ul>
 */
public class RemoteControlInvokerCommand {

    /** 버튼 번호 → 꽂혀 있는 명령 */
    private final Map<Integer, RemoteCommand> buttons = new HashMap<>();

    /** 실행 기록 (스택: 마지막에 넣은 것을 먼저 꺼냄 = LIFO) */
    private final Deque<RemoteCommand> history = new ArrayDeque<>();

    /**
     * 버튼에 명령을 꽂습니다. 이미 꽂힌 명령이 있으면 교체됩니다.
     *
     * @param buttonNumber 버튼 번호
     * @param command      꽂을 명령
     */
    public void setCommand(int buttonNumber, RemoteCommand command) {
        buttons.put(buttonNumber, command);
    }

    /**
     * 버튼을 누릅니다. 꽂힌 명령을 실행하고 실행 기록에 저장합니다.
     *
     * @param buttonNumber 누를 버튼 번호
     */
    public void pressButton(int buttonNumber) {
        RemoteCommand command = buttons.get(buttonNumber);
        if (command == null) {
            System.out.println("  [리모컨] " + buttonNumber + "번 버튼은 비어 있습니다.");
            return;
        }
        System.out.println("  [리모컨] " + buttonNumber + "번 버튼 → '" + command.getName() + "'");
        command.execute();       // 무슨 일을 하는지 모르지만 일단 실행!
        history.push(command);   // 실행 기록에 저장
    }

    /**
     * 실행 취소 버튼입니다. (Ctrl+Z 같은 기능)
     * 가장 최근에 실행한 명령을 꺼내서 되돌립니다.
     */
    public void pressUndo() {
        if (history.isEmpty()) {
            System.out.println("  [리모컨] 취소할 명령이 없습니다.");
            return;
        }
        RemoteCommand last = history.pop();   // 가장 최근 명령을 꺼냄
        System.out.println("  [리모컨] 실행 취소 → '" + last.getName() + "' 되돌리기");
        last.undo();
    }
}
