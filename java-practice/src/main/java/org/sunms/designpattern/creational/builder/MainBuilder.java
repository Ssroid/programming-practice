package org.sunms.designpattern.creational.builder;

/**
 * 빌더 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 */
public class MainBuilder {

    /**
     * <b>빌더 패턴(Builder Pattern)</b>: 옵션이 많은 복잡한 객체를 "한 단계씩" 조립해서 만드는 생성 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나? (점층적 생성자 문제)</h4>
     * <p>햄버거에는 빵, 패티, 치즈, 양상추, 토마토, 소스 ... 옵션이 많습니다. 생성자로 만들면?</p>
     * <pre>{@code
     * new Burger("참깨빵", "소고기", true, false, true, "바베큐");
     * }</pre>
     * <ul>
     *   <li>{@code true, false, true}가 각각 뭔지 전혀 알 수 없음!</li>
     *   <li>순서를 헷갈리면 엉뚱한 버거가 만들어짐 (컴파일러도 못 잡아줌)</li>
     *   <li>치즈만 빼고 싶은데 모든 값을 다 넣어야 함</li>
     * </ul>
     *
     * <h4>해결 방법</h4>
     * <p>"빌더(Builder)"라는 조립 담당 객체를 따로 두고, 메서드 이름으로 옵션을 지정!</p>
     * <pre>{@code
     * new BurgerBuilder("참깨빵", "소고기 패티")
     *         .cheese()
     *         .tomato()
     *         .sauce("바베큐")
     *         .build();
     * }</pre>
     * <p>→ 무엇을 넣었는지 한눈에 보이고, 필요한 옵션만 골라서 넣으면 됩니다.</p>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Product</b>: {@link BurgerProductBuilder} (완성된 햄버거. 한 번 만들면 변경 불가)</li>
     *   <li><b>Builder</b>: {@link BurgerBuilder} (재료를 하나씩 받아서 조립)</li>
     *   <li><b>Director</b>: {@link BurgerDirectorBuilder} (자주 쓰는 "정해진 레시피"를 대신 조립해 줌, 선택 사항)</li>
     * </ul>
     * <p>※ GoF 원본에는 Builder 인터페이스가 있지만(같은 조립 과정으로 다른 결과물 만들기),
     * 실무에서 쓰는 빌더는 이 예제처럼 인터페이스 없이 클래스 하나로 만드는 경우가 대부분입니다.</p>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 가독성 최고, 필수/선택 값 구분, 불변(immutable) 객체 만들기 쉬움</li>
     *   <li><b>단점</b>: 빌더 클래스를 추가로 작성해야 함 (코드량 증가)</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>{@code StringBuilder} (문자열을 조금씩 붙여서 완성)</li>
     *   <li>Lombok의 {@code @Builder} 어노테이션 (빌더 코드를 자동 생성!)</li>
     *   <li>HTTP 요청 객체: {@code HttpRequest.newBuilder().uri(...).GET().build()}</li>
     * </ul>
     *
     * <p>(참고) 실무에서는 빌더를 제품 클래스 "안쪽"에 {@code static class}로 넣는 경우가 많습니다.
     * 여기서는 이해하기 쉽도록 파일을 나눴습니다.</p>
     * <pre>{@code
     * Burger burger = new Burger.Builder(...).cheese().build();
     * }</pre>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {

        System.out.println("===== 1. 빌더로 나만의 햄버거 만들기 =====");
        BurgerProductBuilder myBurger = new BurgerBuilder("통밀빵", "치킨 패티") // 필수 값
                .cheese()               // 치즈 추가
                .tomato()               // 토마토 추가
                .sauce("허니머스타드")  // 소스 선택
                .extra("베이컨")        // 추가 토핑
                .extra("할라피뇨")
                .build();               // 완성!
        System.out.println("  " + myBurger);

        System.out.println();
        System.out.println("===== 2. 필요한 옵션만 골라 넣기 (심플 버거) =====");
        BurgerProductBuilder simpleBurger = new BurgerBuilder("참깨빵", "소고기 패티")
                .build();               // 옵션 없이 바로 완성해도 OK
        System.out.println("  " + simpleBurger);

        System.out.println();
        System.out.println("===== 3. Director 에게 정해진 메뉴 주문 =====");
        BurgerDirectorBuilder director = new BurgerDirectorBuilder();
        System.out.println("  " + director.makeBulgogiBurger());
        System.out.println("  " + director.makeCheeseBurger());

        /*
         * [빌더가 없었다면?]
         *   new Burger("통밀빵", "치킨 패티", true, false, true, "허니머스타드", List.of("베이컨", "할라피뇨"));
         *   → true, false, true 가 각각 무엇인지 알아보기 어렵습니다.
         *
         * [Lombok 을 쓰면?] 클래스 위에 @Builder 만 붙이면 BurgerBuilder 같은 코드를 자동 생성해 줍니다.
         */
    }
}
