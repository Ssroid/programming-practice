package org.sunms.designpattern.creational.singleton;

/**
 * 싱글톤 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 *
 * <h2>확인할 포인트</h2>
 * <ol>
 *   <li>생성자 메시지가 딱 한 번만 출력되는가?</li>
 *   <li>{@code getInstance()}를 여러 번 불러도 "같은 객체({@code ==})"인가?</li>
 *   <li>한 곳에서 바꾼 설정이 다른 곳에서도 보이는가?</li>
 * </ol>
 */
public class MainSingleton {

    /**
     * <b>싱글톤 패턴(Singleton Pattern)</b>: 객체를 딱 1개만 만들고, 어디서든 그 객체를 함께 쓰도록 하는
     * 생성 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>앱의 "설정 정보(언어, 테마 등)"를 관리하는 객체가 있다고 해봅시다.
     * 화면 A에서 {@code new AppConfig()}로 만들고 언어를 "영어"로 바꿨는데,
     * 화면 B에서 또 {@code new AppConfig()}를 하면 완전히 다른 객체라서 "한국어" 그대로!<br>
     * → 설정이 여기저기 따로 놀게 됩니다.</p>
     *
     * <h4>해결 방법 (3가지 핵심 규칙)</h4>
     * <ol>
     *   <li>생성자를 {@code private}으로 막는다 → 밖에서 {@code new}로 만들 수 없게</li>
     *   <li>자기 자신을 담는 {@code static} 변수를 둔다 → 유일한 객체를 보관할 곳</li>
     *   <li>{@code static getInstance()} 메서드를 둔다 → 그 유일한 객체를 꺼내 주는 창구</li>
     * </ol>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Singleton</b>: {@link BasicSingleton} (원리 이해용 기본형, 멀티 스레드에 안전하지 않음)</li>
     *   <li><b>Singleton</b>: {@link AppConfigSingleton} (실무형, 홀더 방식으로 스레드 안전)</li>
     * </ul>
     * <p>※ 싱글톤은 "객체 개수"를 제한하는 패턴이라 인터페이스가 필수가 아닌,
     * 클래스 하나로 완성되는 패턴입니다.</p>
     *
     * <h4>실생활 비유</h4>
     * <p>회사의 "대표이사"는 한 명뿐. 누가 찾든 같은 사람에게 연결됩니다.</p>
     *
     * <h4>장점</h4>
     * <ul>
     *   <li>메모리 낭비 없음 (객체 1개)</li>
     *   <li>어디서든 같은 데이터를 공유</li>
     * </ul>
     *
     * <h4>단점 / 주의</h4>
     * <ul>
     *   <li>전역 변수처럼 쓰이기 쉬워 → 남용하면 코드끼리 강하게 얽힘</li>
     *   <li>단위 테스트가 어려워짐 (가짜 객체로 바꿔 끼우기 힘듦)</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>설정 관리자, 로그 기록기(Logger), DB 커넥션 풀</li>
     *   <li>스프링(Spring)의 Bean은 기본적으로 싱글톤으로 관리됩니다!</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {

        System.out.println("===== 1. 기본 싱글톤 =====");
        BasicSingleton a = BasicSingleton.getInstance(); // 처음 호출 → 생성됨
        BasicSingleton b = BasicSingleton.getInstance(); // 두 번째 호출 → 기존 객체 반환
        a.hello();

        // == 은 "같은 객체인가?"를 비교합니다 (내용 비교가 아니라 주소 비교)
        System.out.println("  a == b ? " + (a == b));   // true

        // BasicSingleton c = new BasicSingleton();   // ← 주석 풀면 컴파일 에러! (생성자가 private)

        System.out.println();
        System.out.println("===== 2. 실무형 싱글톤 (설정 관리자) =====");

        // 화면 A 에서 설정을 가져와 언어를 바꿈
        System.out.println("[화면 A] 언어를 English 로 변경합니다.");
        AppConfigSingleton configInScreenA = AppConfigSingleton.getInstance();
        configInScreenA.set("language", "English");

        // 화면 B 에서 설정을 가져옴 → 같은 객체이므로 바뀐 값이 보여야 함
        System.out.println("[화면 B] 현재 언어 설정을 확인합니다.");
        AppConfigSingleton configInScreenB = AppConfigSingleton.getInstance();
        System.out.println("  현재 언어 = " + configInScreenB.get("language")); // English

        System.out.println("  화면 A 와 화면 B 의 설정 객체가 같은가? " + (configInScreenA == configInScreenB));

        /*
         * [만약 싱글톤이 아니었다면?]
         *   AppConfig configA = new AppConfig();  configA.set("language", "English");
         *   AppConfig configB = new AppConfig();  configB.get("language");  // → "한국어" (서로 다른 객체!)
         *   → 화면마다 설정이 달라지는 버그 발생
         */
    }
}
