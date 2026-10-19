package org.sunms.designpattern.behavioral.templatemethod;

/**
 * 템플릿 메서드 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 *
 * <h2>확인할 포인트</h2>
 * <p>세 음료 모두 {@code prepareRecipe()} 하나만 호출하는데, 순서는 같고 내용만 다르다.</p>
 */
public class MainTemplateMethod {

    /**
     * <b>템플릿 메서드 패턴(Template Method Pattern)</b>: 전체 작업 "순서(뼈대)"는 부모가 정하고,
     * 단계별 "세부 내용"만 자식이 채우는 행위 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <ul>
     *   <li>커피 만들기: 물 끓이기 → 커피 우리기 → 컵에 따르기 → 설탕/우유 추가</li>
     *   <li>홍차 만들기: 물 끓이기 → 찻잎 우리기 → 컵에 따르기 → 레몬 추가</li>
     * </ul>
     * <p>→ 1, 3 단계는 완전히 똑같고, 2, 4 단계만 다릅니다.<br>
     * → 클래스마다 따로 작성하면 중복 코드 발생! 순서를 실수로 바꿀 수도 있습니다.</p>
     *
     * <h4>해결 방법</h4>
     * <ol>
     *   <li>부모 클래스에 "순서"를 정의한 메서드(템플릿 메서드)를 만들고 {@code final}로 고정</li>
     *   <li>공통 단계(물 끓이기, 따르기)는 부모가 직접 구현</li>
     *   <li>달라지는 단계(우리기, 첨가물)는 {@code abstract}로 비워 두고 자식이 구현</li>
     * </ol>
     *
     * <h4>실생활 비유</h4>
     * <ul>
     *   <li>이력서 양식: 칸(이름, 학력, 경력)의 순서는 정해져 있고 내용만 각자 채움</li>
     *   <li>라면 끓이기: 물 끓이기 → 면 넣기 → 스프 넣기 (라면 종류만 다름)</li>
     * </ul>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Abstract Class</b>: {@link BeverageTemplateMethod} (뼈대 + 공통 단계, 추상 클래스)</li>
     *   <li><b>Concrete Class</b>: {@link CoffeeTemplateMethod}, {@link TeaTemplateMethod} (다른 단계만 구현)</li>
     * </ul>
     *
     * <h4>훅(Hook) 메서드란?</h4>
     * <p>기본 구현이 있어서 자식이 "원하면" 재정의할 수 있는 선택적 단계입니다.
     * (이 예제의 {@code customerWantsCondiments()} → 블랙커피가 재정의해서 4단계를 건너뜀)</p>
     *
     * <h4>할리우드 원칙: "우리가 연락할게요, 먼저 연락하지 마세요"</h4>
     * <p>자식은 부모를 호출하지 않고, 부모(템플릿 메서드)가 필요할 때 자식의 메서드를 호출합니다.</p>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 중복 코드 제거, 알고리즘 순서를 한곳에서 통제</li>
     *   <li><b>단점</b>: 상속 기반이라 부모가 바뀌면 자식 모두 영향, 단계가 많으면 이해하기 어려움</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>스프링의 {@code JdbcTemplate}, {@code RestTemplate}: 연결/예외처리/종료는 템플릿이, SQL만 우리가!</li>
     *   <li>{@code AbstractList}, {@code HttpServlet} ({@code doGet}/{@code doPost}만 구현하면 됨)</li>
     *   <li>JUnit의 {@code @BeforeEach} → {@code @Test} → {@code @AfterEach} 흐름</li>
     * </ul>
     *
     * <h4>전략 패턴과의 차이</h4>
     * <ul>
     *   <li><b>템플릿 메서드</b>: "상속"으로 일부 단계만 바꿈</li>
     *   <li><b>전략</b>: "객체 조합"으로 알고리즘 전체를 갈아 끼움</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {

        System.out.println("===== 커피 =====");
        BeverageTemplateMethod coffee = new CoffeeTemplateMethod(false);
        coffee.prepareRecipe();

        System.out.println();
        System.out.println("===== 블랙커피 (훅으로 4단계 생략) =====");
        BeverageTemplateMethod blackCoffee = new CoffeeTemplateMethod(true);
        blackCoffee.prepareRecipe();

        System.out.println();
        System.out.println("===== 홍차 =====");
        BeverageTemplateMethod tea = new TeaTemplateMethod();
        tea.prepareRecipe();
    }
}
