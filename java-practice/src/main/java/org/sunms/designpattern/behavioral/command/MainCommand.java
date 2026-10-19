package org.sunms.designpattern.behavioral.command;

/**
 * 커맨드 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 */
public class MainCommand {

    /**
     * <b>커맨드 패턴(Command Pattern)</b>: "요청(명령)" 자체를 객체로 만들어서
     * 저장, 전달, 취소(Undo)를 할 수 있게 하는 행위 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>스마트홈 리모컨을 만든다고 해봅시다.</p>
     * <pre>{@code
     * if (button == 1) light.on();
     * else if (button == 2) aircon.on();  ...
     * }</pre>
     * <ul>
     *   <li>리모컨이 모든 가전제품을 직접 알아야 함 (가전 추가 시 리모컨 코드 수정)</li>
     *   <li>"방금 누른 것 취소(Undo)" 기능을 만들기 어려움 (무엇을 했는지 기록이 없으니까)</li>
     * </ul>
     *
     * <h4>해결 방법</h4>
     * <p>"불 켜기", "에어컨 켜기" 같은 요청을 각각 객체(Command)로 포장합니다.</p>
     * <ul>
     *   <li>리모컨은 버튼에 "명령 객체"만 꽂아 두고, 누르면 {@code command.execute()}만 호출</li>
     *   <li>실행한 명령을 기록(Stack)해 두면 → 거꾸로 {@code undo()} 하면 실행 취소!</li>
     * </ul>
     *
     * <h4>실생활 비유</h4>
     * <p>식당 주문서: 손님(Client)이 주문 → 웨이터(Invoker)가 주문서(Command)를 주방에 전달
     * → 요리사(Receiver)가 요리. 웨이터는 요리법을 몰라도 됩니다!</p>
     *
     * <h4>역할 정리 (파일 이름에 역할을 넣어 두었습니다)</h4>
     * <ul>
     *   <li><b>Command</b>: {@link RemoteCommand} (명령의 공통 규격, 인터페이스)</li>
     *   <li><b>Concrete Command</b>: {@link LightOnCommand}, {@link LightOffCommand}, {@link AirConditionerOnCommand}</li>
     *   <li><b>Receiver</b>: {@link LightReceiverCommand}, {@link AirConditionerReceiverCommand} (실제로 일하는 가전)</li>
     *   <li><b>Invoker</b>: {@link RemoteControlInvokerCommand} (명령을 실행시키는 리모컨)</li>
     *   <li><b>Client</b>: 이 {@code main()} 메서드 (명령 객체를 만들어 리모컨에 꽂음)</li>
     * </ul>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 요청하는 쪽과 처리하는 쪽 분리, Undo/Redo, 작업 대기열(Queue), 로그 기록 가능</li>
     *   <li><b>단점</b>: 명령마다 클래스가 생겨서 파일 수가 많아짐</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>텍스트 에디터의 Ctrl+Z (실행 취소) / Ctrl+Y (다시 실행)</li>
     *   <li>{@code Runnable} 인터페이스: 실행할 작업을 객체로 만들어 스레드에 전달</li>
     *   <li>작업 큐(Job Queue), 매크로 기록, DB 트랜잭션 롤백</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        // 1) 실제로 일하는 가전제품 (Receiver)
        LightReceiverCommand light = new LightReceiverCommand();
        AirConditionerReceiverCommand airConditioner = new AirConditionerReceiverCommand();

        // 2) 리모컨 (Invoker)
        RemoteControlInvokerCommand remote = new RemoteControlInvokerCommand();

        // 3) 버튼에 명령 객체를 꽂기 (Client 가 조립)
        remote.setCommand(1, new LightOnCommand(light));
        remote.setCommand(2, new LightOffCommand(light));
        remote.setCommand(3, new AirConditionerOnCommand(airConditioner, 22));

        System.out.println("===== 1. 버튼 누르기 =====");
        remote.pressButton(1);   // 조명 켜기
        remote.pressButton(3);   // 에어컨 켜기
        remote.pressButton(2);   // 조명 끄기
        remote.pressButton(9);   // 빈 버튼

        System.out.println();
        System.out.println("===== 2. 실행 취소 (최근 것부터 거꾸로) =====");
        remote.pressUndo();      // 조명 끄기 취소 → 조명 켜짐
        remote.pressUndo();      // 에어컨 켜기 취소 → 에어컨 꺼짐
        remote.pressUndo();      // 조명 켜기 취소 → 조명 꺼짐
        remote.pressUndo();      // 더 이상 없음

        System.out.println();
        System.out.println("===== 3. 버튼 기능 바꾸기 (리모컨 코드 수정 없이!) =====");
        remote.setCommand(1, new AirConditionerOnCommand(airConditioner, 18));   // 1번 버튼을 "에어컨 18도"로 교체
        remote.pressButton(1);
    }
}
