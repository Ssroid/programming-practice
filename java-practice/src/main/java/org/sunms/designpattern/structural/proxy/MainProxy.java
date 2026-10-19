package org.sunms.designpattern.structural.proxy;

import java.util.List;

/**
 * 프록시 패턴 실행 예제입니다. (▶ 버튼으로 실행해 보세요)
 *
 * <h2>확인할 포인트</h2>
 * <ul>
 *   <li>프록시 없이: 앨범을 열자마자 3장 모두 로딩 (느림)</li>
 *   <li>프록시 사용: 사용자가 실제로 본 1장만 로딩 (빠름)</li>
 * </ul>
 */
public class MainProxy {

    /**
     * <b>프록시 패턴(Proxy Pattern)</b>: 진짜 객체 앞에 "대리인(Proxy)"을 세워서,
     * 접근을 대신 관리하게 하는 구조 패턴입니다.
     *
     * <h4>어떤 문제를 해결하나?</h4>
     * <p>사진 앱에서 고화질 이미지 100장을 불러온다고 해봅시다.
     * 이미지 객체를 만들자마자 디스크에서 읽어 오면 → 앱 시작이 엄청 느려집니다!
     * 그런데 사용자는 화면에 보이는 몇 장만 실제로 봅니다.</p>
     *
     * <h4>해결 방법</h4>
     * <p>진짜 이미지 대신 가벼운 "대리인"을 먼저 만들어 둡니다.
     * 대리인은 파일 이름만 기억하고 있다가,
     * 실제로 {@code display()}가 호출되는 순간에 비로소 진짜 이미지를 로딩합니다. (지연 로딩)</p>
     *
     * <h4>실생활 비유</h4>
     * <p>연예인(진짜 객체)에게 바로 연락하지 않고 매니저(프록시)를 거칩니다.
     * 매니저는 일정 관리, 출연료 확인 등을 처리하고 필요할 때만 연예인에게 전달합니다.</p>
     *
     * <h4>역할 정리</h4>
     * <ul>
     *   <li><b>Subject</b>: {@link ImageProxy} (진짜와 대리인의 공통 규격, 인터페이스)</li>
     *   <li><b>Real Subject</b>: {@link RealImageProxy} (진짜 이미지, 생성 비용이 큼)</li>
     *   <li><b>Proxy</b>: {@link LazyImageProxy} (대리인, 필요할 때만 진짜를 만듦)</li>
     * </ul>
     * <p>★ 진짜와 대리인이 "같은 인터페이스"를 구현하는 것이 핵심!
     * → 사용하는 쪽은 대리인인지 진짜인지 구분할 필요가 없습니다.</p>
     *
     * <h4>프록시의 종류</h4>
     * <ul>
     *   <li><b>가상 프록시(Virtual)</b>: 무거운 객체를 필요할 때까지 생성 미루기 (← 이 예제)</li>
     *   <li><b>보호 프록시(Protection)</b>: 권한 있는 사용자만 접근 허용</li>
     *   <li><b>캐싱 프록시(Caching)</b>: 결과를 저장해 두고 재사용</li>
     *   <li><b>원격 프록시(Remote)</b>: 다른 서버에 있는 객체를 로컬처럼 사용</li>
     * </ul>
     *
     * <h4>데코레이터와의 차이</h4>
     * <p>구조는 비슷하지만 "목적"이 다릅니다.</p>
     * <ul>
     *   <li><b>데코레이터</b>: 기능을 "추가" (토핑 덧붙이기)</li>
     *   <li><b>프록시</b>: 접근을 "제어" (언제/누가 진짜를 쓸지 관리)</li>
     * </ul>
     *
     * <h4>실무 예시</h4>
     * <ul>
     *   <li>JPA(Hibernate)의 지연 로딩(Lazy Loading): 연관된 엔티티를 프록시로 가져옴</li>
     *   <li>스프링 AOP, {@code @Transactional}: 프록시가 메서드 호출 앞뒤로 트랜잭션 처리</li>
     * </ul>
     *
     * @param args 실행 인자 (사용하지 않음)
     */
    public static void main(String[] args) {

        System.out.println("===== 1. 프록시 없이 앨범 열기 =====");
        long start = System.currentTimeMillis();
        List<ImageProxy> album1 = List.of(
                new RealImageProxy("여행1.jpg"),    // 만들자마자 로딩...
                new RealImageProxy("여행2.jpg"),    // 로딩...
                new RealImageProxy("여행3.jpg"));   // 로딩...
        System.out.println("  앨범 여는 데 걸린 시간: " + (System.currentTimeMillis() - start) + "ms");
        album1.get(0).display();   // 실제로 본 건 1장뿐인데 3장 다 로딩했음!

        System.out.println();
        System.out.println("===== 2. 프록시로 앨범 열기 =====");
        start = System.currentTimeMillis();
        List<ImageProxy> album2 = List.of(
                new LazyImageProxy("여행1.jpg"),    // 이름만 기억 (가벼움)
                new LazyImageProxy("여행2.jpg"),
                new LazyImageProxy("여행3.jpg"));
        System.out.println("  앨범 여는 데 걸린 시간: " + (System.currentTimeMillis() - start) + "ms");

        System.out.println("  [사용자가 첫 번째 사진 클릭]");
        album2.get(0).display();   // 이때 1장만 로딩
        System.out.println("  [사용자가 첫 번째 사진 다시 클릭]");
        album2.get(0).display();   // 재사용 (로딩 없음)

        /*
         * album1 과 album2 모두 List<ImageProxy> 타입!
         * → 사용하는 쪽은 진짜인지 프록시인지 신경 쓸 필요가 없습니다.
         */
    }
}
