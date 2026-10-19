package org.sunms.designpattern.behavioral.command;

/**
 * "명령이라면 실행({@link #execute()})하고 취소({@link #undo()})할 수 있어야 한다"는 규격입니다.
 *
 * <p><b>역할:</b> Command (명령의 공통 규격)<br>
 * 패턴 전체 설명은 {@link MainCommand#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>이 인터페이스는 무엇인가?</h2>
 * <p>"조명 켜기", "에어컨 켜기" 같은 요청 하나하나가 이 규격을 구현한 객체가 됩니다.</p>
 *
 * <h2>왜 인터페이스가 필요한가?</h2>
 * <ol>
 *   <li>리모컨(Invoker)이 가전제품을 하나도 몰라도 되게 하기 위해서입니다.
 *       <pre>{@code
 * command.execute();   // 조명이든 에어컨이든, 리모컨은 이것만 호출
 * }</pre></li>
 *   <li>서로 다른 종류의 명령을 "한 목록"에 담아 실행 기록(Undo 스택)을 만들기 위해서입니다.
 *       <pre>{@code
 * Deque<RemoteCommand> history;   // 조명 명령, 에어컨 명령이 섞여 있어도 OK
 * history.pop().undo();           // 무슨 명령이었는지 몰라도 취소 가능!
 * }</pre></li>
 * </ol>
 *
 * <h2>왜 추상화가 필요한가? (인터페이스가 없다면?)</h2>
 * <p>리모컨이 {@link LightReceiverCommand}, {@link AirConditionerReceiverCommand}를 직접 알고
 * 버튼마다 if 문으로 {@code light.on()}, {@code aircon.powerOn(22)}를 호출해야 합니다.</p>
 * <ul>
 *   <li>TV가 추가되면 리모컨 코드를 수정해야 하고</li>
 *   <li>"방금 한 일"을 기록할 공통 타입이 없어서 Undo를 만들 수 없습니다.</li>
 * </ul>
 * <p>→ 요청을 공통 규격의 객체로 추상화하면, 요청을 "변수처럼" 저장하고, 전달하고, 되돌릴 수 있습니다.</p>
 *
 * @see LightOnCommand
 * @see LightOffCommand
 * @see AirConditionerOnCommand
 * @see RemoteControlInvokerCommand
 */
public interface RemoteCommand {

    /**
     * 명령을 실행합니다.
     */
    void execute();

    /**
     * 명령을 취소합니다. ({@link #execute()}의 반대 동작)
     */
    void undo();

    /**
     * 명령 이름을 알려줍니다. (로그 출력용)
     *
     * @return 명령 이름 (예: "조명 켜기")
     */
    String getName();
}
