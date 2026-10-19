package org.sunms.designpattern.creational.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로토타입 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 *
 * <h2>확인할 포인트</h2>
 * <ul>
 *   <li>복사본을 수정해도 원본은 그대로인가? (깊은 복사)</li>
 *   <li>얕은 복사를 하면 어떤 문제가 생기는가?</li>
 * </ul>
 */
public class MainPrototype {

    /**
     * <b>프로토타입 패턴(Prototype Pattern)</b>: 처음부터 {@code new}로 만들지 말고,
     * 이미 있는 객체를 "복사"해서 새 객체를 만드는 생성 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>회사에서 "주간 보고서"를 쓸 때마다 매번 처음부터 양식(제목, 작성자, 목차...)을
     * 다시 입력한다면 번거롭습니다. 그리고 객체 생성 비용이 클 수도 있습니다.
     * (예: DB 조회, 파일 읽기 등을 거쳐야 완성되는 객체)</p>
     *
     * <h4>해결 방법</h4>
     * <p>잘 만들어 둔 "원본(템플릿)"을 하나 두고, 필요할 때마다 {@code copy()} 해서
     * 달라지는 부분만 수정해서 사용합니다.</p>
     *
     * <h4>실생활 비유</h4>
     * <p>워드 문서 "다른 이름으로 저장" / 복사기로 양식지 복사</p>
     *
     * <h4>★★ 가장 중요한 개념: 얕은 복사 vs 깊은 복사 ★★</h4>
     * <ul>
     *   <li><b>얕은 복사(Shallow Copy)</b>: 리스트 같은 "참조 타입" 필드는 주소만 복사
     *       → 원본과 복사본이 같은 리스트를 공유! 한쪽을 바꾸면 다른 쪽도 바뀜 (버그!)</li>
     *   <li><b>깊은 복사(Deep Copy)</b>: 리스트까지 새로 만들어서 내용물을 복사
     *       → 원본과 복사본이 완전히 독립</li>
     * </ul>
     * <p>→ 이 예제는 "깊은 복사"를 사용합니다. ({@link ReportDocumentPrototype#copy()} 참고)</p>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Prototype</b>: {@link DocumentPrototype} ("복사할 수 있다"는 규격, 인터페이스)</li>
     *   <li><b>Concrete Prototype</b>: {@link ReportDocumentPrototype} (실제 복사 방법 구현)</li>
     *   <li><b>Registry (선택)</b>: {@link TemplateRegistryPrototype} (원본 템플릿 보관함)</li>
     * </ul>
     *
     * <h4>장단점</h4>
     * <ul>
     *   <li><b>장점</b>: 생성 비용 절약, 복잡한 초기 설정을 반복하지 않아도 됨</li>
     *   <li><b>단점</b>: 깊은 복사 구현이 까다로울 수 있음 (필드에 객체가 많을수록)</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>자바의 {@code Object.clone()} / {@code Cloneable} 인터페이스</li>
     *   <li>{@code new ArrayList<>(기존리스트)}처럼 "복사 생성자"</li>
     *   <li>게임에서 같은 몬스터를 대량으로 복제</li>
     * </ul>
     *
     * <p>(참고) 자바의 {@code clone()}은 사용법이 까다롭고 함정이 많아서,
     * 실무에서는 이 예제처럼 직접 {@code copy()} 메서드나 "복사 생성자"를 만드는 방식을 더 권장합니다.</p>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {
        TemplateRegistryPrototype registry = new TemplateRegistryPrototype();

        System.out.println("===== 1. 템플릿을 복사해서 각자 보고서 작성 =====");
        ReportDocumentPrototype kimReport = registry.create("주간보고");
        kimReport.setAuthor("김개발");
        kimReport.addSection("3. 이슈 사항");     // 김개발만 목차 추가

        ReportDocumentPrototype leeReport = registry.create("주간보고");
        leeReport.setAuthor("이디자인");

        System.out.println("  김개발: " + kimReport);
        System.out.println("  이디자인: " + leeReport);
        System.out.println("  원본: " + registry.peekOriginal("주간보고"));
        System.out.println("  → 김개발이 목차를 추가해도 원본과 이디자인 보고서는 그대로!");

        System.out.println();
        System.out.println("===== 2. [비교] 얕은 복사를 하면 생기는 문제 =====");
        List<String> originalList = new ArrayList<>(List.of("목차1", "목차2"));

        // 얕은 복사를 하면 객체 안의 리스트 필드는 아래처럼 "주소만" 복사됩니다.
        List<String> shallowCopy = originalList;                  // 주소만 복사 → 같은 리스트를 가리킴
        List<String> deepCopy = new ArrayList<>(originalList);    // 새 리스트를 만들어 내용물 복사

        shallowCopy.add("얕은복사에서 추가");
        deepCopy.add("깊은복사에서 추가");

        System.out.println("  원본 리스트   : " + originalList);   // 얕은 복사의 변경이 원본에 섞여 들어감!
        System.out.println("  깊은 복사본   : " + deepCopy);
        System.out.println("  → 얕은 복사본을 바꿨더니 원본까지 바뀌었습니다. 그래서 깊은 복사가 중요!");
    }
}
