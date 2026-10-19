package org.sunms.designpattern.creational.abstractfactory;

/**
 * 추상 팩토리 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 *
 * <h2>확인할 포인트</h2>
 * <ul>
 *   <li>{@link #decorateLivingRoom(FurnitureAbstractFactory)}는 "모던"인지 "클래식"인지 전혀 모른다.</li>
 *   <li>공장만 바꿔 끼우면 거실 전체 스타일이 통째로 바뀐다.</li>
 * </ul>
 */
public class MainAbstractFactory {

    /**
     * 거실을 꾸밉니다. (Client 코드)
     *
     * <p>매개변수 타입이 인터페이스({@link FurnitureAbstractFactory})이므로
     * 어떤 공장이 들어와도 똑같이 동작합니다.
     * 이 메서드 안에서는 절대로 스타일이 섞일 수 없습니다! (같은 공장에서 나오니까)</p>
     *
     * @param factory 가구를 만들 공장 (모던 또는 클래식)
     */
    static void decorateLivingRoom(FurnitureAbstractFactory factory) {
        ChairAbstractFactory chair = factory.createChair();
        SofaAbstractFactory sofa = factory.createSofa();

        chair.sitOn();
        sofa.lieOn();
    }

    /**
     * <b>추상 팩토리 패턴(Abstract Factory Pattern)</b>: "서로 어울리는 객체들"을 세트(가족)로
     * 한꺼번에 만들어 주는 생성 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>가구점에서 거실 가구를 고르는데,</p>
     * <pre>{@code
     * Chair chair = new ModernChair();
     * Sofa  sofa  = new ClassicSofa();   // ← 실수! 스타일이 안 맞음
     * }</pre>
     * <p>직접 {@code new}를 하다 보면 이렇게 "세트가 섞이는" 실수가 생깁니다.</p>
     *
     * <h4>해결 방법</h4>
     * <p>"모던 공장", "클래식 공장"을 따로 만들어서
     * 공장 하나를 고르면 → 그 공장에서 나오는 모든 가구는 같은 스타일로 보장!</p>
     *
     * <h4>팩토리 메서드와의 차이</h4>
     * <ul>
     *   <li><b>팩토리 메서드</b>: 제품 "1종류"를 만드는 메서드 하나에 집중 (상속 사용)</li>
     *   <li><b>추상 팩토리</b>: 관련된 제품 "여러 종류(의자+소파+...)"를 세트로 생성 (객체 조합 사용)</li>
     * </ul>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Abstract Factory</b>: {@link FurnitureAbstractFactory} ("어떤 가구들을 만들 수 있나" 목록, 인터페이스)</li>
     *   <li><b>Concrete Factory</b>: {@link ModernFurnitureAbstractFactory}, {@link ClassicFurnitureAbstractFactory}</li>
     *   <li><b>Abstract Product</b>: {@link ChairAbstractFactory}, {@link SofaAbstractFactory} (인터페이스)</li>
     *   <li><b>Concrete Product</b>: Modern/Classic + Chair/Sofa</li>
     *   <li><b>Client</b>: {@link #decorateLivingRoom(FurnitureAbstractFactory)} (공장 인터페이스만 사용)</li>
     * </ul>
     *
     * <h4>실생활 비유</h4>
     * <p>이케아 "쇼룸 세트"를 고르면 의자, 소파, 테이블이 전부 한 스타일로 맞춰져 나옴.</p>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 제품끼리 호환성 보장, 스타일(테마) 전체 교체가 공장 교체 한 줄로 끝</li>
     *   <li><b>단점</b>: 새 "제품 종류"(예: 테이블) 추가 시 모든 공장을 수정해야 함</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>운영체제별 UI 컴포넌트 (윈도우 버튼+체크박스 / 맥 버튼+체크박스)</li>
     *   <li>DB 종류별 커넥션/커맨드 객체 세트 (MySQL 세트, Oracle 세트)</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {

        System.out.println("===== 모던 스타일 거실 =====");
        decorateLivingRoom(new ModernFurnitureAbstractFactory());

        System.out.println();
        System.out.println("===== 클래식 스타일 거실 =====");
        decorateLivingRoom(new ClassicFurnitureAbstractFactory());   // 공장만 바꿨을 뿐!

        /*
         * [실무 팁]
         * 사용자가 설정에서 "테마"를 고르면, 프로그램 시작 시 공장 하나만 정해 두고
         * 나머지 코드는 그 공장만 사용 → 테마 전환이 아주 쉬워집니다.
         *
         *   FurnitureAbstractFactory factory =
         *       userTheme.equals("modern") ? new ModernFurnitureAbstractFactory()
         *                                  : new ClassicFurnitureAbstractFactory();
         */
    }
}
