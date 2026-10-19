package org.sunms.designpattern.behavioral.templatemethod;

/**
 * "음료 만들기 레시피의 순서표"입니다.
 * 순서({@link #prepareRecipe()})와 공통 단계(물 끓이기, 따르기)는 여기서 구현하고,
 * 음료마다 다른 단계(우리기, 첨가물)는 비워 두고 자식에게 맡깁니다.
 *
 * <p><b>역할:</b> Abstract Class (작업 순서의 뼈대)<br>
 * 패턴 전체 설명은 {@link MainTemplateMethod#main(String[])}의 주석을 참고하세요.</p>
 *
 * <h2>왜 인터페이스가 아니라 "추상 클래스"인가?</h2>
 * <p>템플릿 메서드 패턴은 다음 세 가지가 꼭 필요한데, 인터페이스로는 할 수 없습니다.</p>
 * <ol>
 *   <li>{@code final} 메서드로 순서를 고정 → 인터페이스 메서드는 {@code final}로 막을 수 없음</li>
 *   <li>{@code private} 공통 단계 구현 → 자식이 바꾸지 못하게 숨겨야 함</li>
 *   <li>"일부는 구현, 일부는 비워 둠" → 공통 코드 + {@code abstract} 메서드의 조합</li>
 * </ol>
 *
 * <h2>왜 추상화가 필요한가? (추상 클래스가 없다면?)</h2>
 * <p>커피 클래스와 홍차 클래스가 각자 {@code prepareRecipe()}를 처음부터 끝까지 작성해야 합니다.</p>
 * <ul>
 *   <li>"물 끓이기", "컵에 따르기" 코드가 클래스마다 복사됨 (중복)</li>
 *   <li>누군가 실수로 "따르기 → 우리기" 순서로 작성해도 막을 방법이 없음</li>
 * </ul>
 * <p>→ 추상 클래스로 뼈대를 고정하면, 자식은 "빈칸 채우기"만 하면 되고 순서는 절대 틀리지 않습니다.<br>
 * → {@code abstract}이므로 "무슨 음료인지 모르는 음료"를 {@code new}로 만드는 것도 막아 줍니다.</p>
 *
 * @see CoffeeTemplateMethod
 * @see TeaTemplateMethod
 */
public abstract class BeverageTemplateMethod {

    /**
     * ★ 템플릿 메서드 ★ 음료 만드는 전체 순서를 정의합니다.
     *
     * <ol>
     *   <li>물 끓이기 (공통)</li>
     *   <li>우려내기 (자식마다 다름)</li>
     *   <li>컵에 따르기 (공통)</li>
     *   <li>첨가물 넣기 (자식마다 다름, 훅으로 생략 가능)</li>
     * </ol>
     * <p>{@code final}이므로 자식이 순서를 마음대로 바꾸지 못합니다!</p>
     */
    public final void prepareRecipe() {
        boilWater();                    // 1. 공통
        brew();                         // 2. 자식마다 다름
        pourInCup();                    // 3. 공통
        if (customerWantsCondiments()) { // 4. 훅으로 할지 말지 결정
            addCondiments();            //    자식마다 다름
        }
        System.out.println("  → " + getName() + " 완성!");
    }

    /**
     * 음료 이름을 알려줍니다. (자식이 반드시 구현)
     *
     * @return 음료 이름
     */
    protected abstract String getName();

    /**
     * 2단계: 음료를 우려냅니다. (자식이 반드시 구현)
     */
    protected abstract void brew();

    /**
     * 4단계: 첨가물을 넣습니다. (자식이 반드시 구현)
     */
    protected abstract void addCondiments();

    /**
     * 1단계: 물을 끓입니다. (공통 단계, {@code private}이라 자식이 바꿀 수 없음)
     */
    private void boilWater() {
        System.out.println("  1) 물을 끓입니다.");
    }

    /**
     * 3단계: 컵에 따릅니다. (공통 단계, {@code private}이라 자식이 바꿀 수 없음)
     */
    private void pourInCup() {
        System.out.println("  3) 컵에 따릅니다.");
    }

    /**
     * ★ 훅(Hook) 메서드 ★ 첨가물을 넣을지 결정합니다.
     *
     * <p>기본 구현이 있어서 자식이 "원하면" 재정의할 수 있는 선택적 단계입니다.</p>
     *
     * @return 첨가물을 넣으려면 {@code true} (기본값)
     */
    protected boolean customerWantsCondiments() {
        return true;
    }
}
