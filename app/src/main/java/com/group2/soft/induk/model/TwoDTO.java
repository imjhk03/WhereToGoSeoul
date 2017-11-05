package com.group2.soft.induk.model;

/**
 * Created by JHK on 16. 8. 18..
 */
public class TwoDTO {
    /*
    <addr1>서울특별시 노원구 화랑로 443</addr1>
    <addr2>(공릉동)</addr2>
    <areacode>1</areacode>
    <cat1>A05</cat1>
    <cat2>A0502</cat2>
    <cat3>A05020300</cat3>
    <contentid>820139</contentid>
    <contenttypeid>39</contenttypeid>
    <createdtime>20091014151435</createdtime>
    <firstimage>
    http://tong.visitkorea.or.kr/cms/resource/08/818108_image2_1.jpg
    </firstimage>
    <firstimage2>
    http://tong.visitkorea.or.kr/cms/resource/08/818108_image3_1.jpg
    </firstimage2>
    <mapx>127.0783327605</mapx>
    <mapy>37.6152781546</mapy>
    <mlevel>6</mlevel>
    <modifiedtime>20150630104024</modifiedtime>
    <overview>
    손수 뽑아낸 면을 사용하여 일본의 맛을 살린 우동을 기본으로 하는 일본풍 패밀리레스토랑이다. 운영자 가족이 모두 전문 외식인으로 국내외의 다양한 외식관련 자격증을 가지고 있다. 매스컴에도 등장한적이 있는 맛집이다.<br /> <br /> -연수된 물과 천일염으로 자가 제면, 각종 천연 식품으로만 푹 끓여 만든 시원하고 개운한 우동국물<br /> - 전 가족구성원이 한식, 중식, 일식, 양식조리사 자격증은 물론 일본 복어조리사 자격증과 미국 소블리에 자격증, 미국 위생사(serv safe), 외식전문경영(FMP)등을 소지한 전문 외식경영인으로 철저한 품질관리<br /> - 넓은 주차장과 지하철 6, 7호선 환승역 등 대중교통의 접근성이 편리<br /> - 일어, 중국어, 영어가 능통한 전문 인력 및 사진이 첨부된 영어, 일어 표기 메뉴판<br /> - 매 4~5년마다 실시하는 업소 리뉴얼로 청결하고 쾌적한 환경<br /> - 80명 이상이 동시 사용 가능한 넓고 쾌적한 대 연회실(별관)<br>
    </overview>
    <sigungucode>9</sigungucode>
    <tel>02-977-7100, 977-2100</tel>
    <telname>가가와</telname>
    <title>가가와</title>
    <zipcode>139-808</zipcode>

    --------------------------------------------------------------------------------------------

    <chkcreditcardfood>가능</chkcreditcardfood>
    <firstmenu>샤브샤브 정식, 김치나베정식</firstmenu>
    <infocenterfood>02-977-7100, 02-977-2100</infocenterfood>
    <kidsfacility>0</kidsfacility>
    <opentimefood>11:00 ~ 22:00</opentimefood>
    <packing>전 메뉴 포장 가능</packing>
    <parkingfood>주차 가능</parkingfood>
    <reservationfood>2~3일전 전화 예약 가능 (02-977-7100)</reservationfood>
    <restdatefood>연중무휴</restdatefood>
    <seat>176석</seat>
    <smoking>모두 금연석</smoking>
    <treatmenu>
    요리류 (2인이상 주문가능)<br /> ㆍ소고기샤브샤브 정식<br /> ㆍ스키야끼 정식<br /> ㆍ해물샤브샤브 정식<br /> ㆍ사시미코스<br /> <br /> 정식류<br /> ㆍ야와라카 돈가츠 정식<br /> ㆍ사시미 정식<br /> ㆍ생선카츠 정식<br /> ㆍ모듬카츠 정식 (돈가츠,왕새우,생선까스)<br /> ㆍ가가와 가츠나베정식 (돈까스)<br /> ㆍ가가와 에비나베정식 (왕새우)<br /> ㆍ참치회덮밥 정식<br /> ㆍ알밥 정식<br /> ㆍ초밥 정식<br /> <br /> 돈부리정식류<br /> ㆍ규동 정식 (소고기덮밥)<br /> ㆍ에비텐동 정식 (왕새우덮밥)<br /> ㆍ가츠동 정식 (돈가츠덮밥)<br /> ㆍ카레가츠동 정식 (일본식 카레덮밥, 돈까스)<br /> ㆍ가츠에비동 정식 (돈까스,왕새우튀김믹스덮밥)<br /> ㆍ우나츄 정식 (장어덮밥)<br /> ㆍ스테이크츄 정식<br /> <br /> 우동류<br /> ㆍ사누키 덴뿌라우동 정식<br /> ㆍ최강달인 김치나베정식<br /> ㆍ육개장 우동정식<br /> ㆍ모밀소바정식<br /> ㆍ스키야키우동정식<br /> ㆍ사누키우동<br /> <br /> 일품류<br /> ㆍ텐뿌라모리아와세 (모듬튀김)<br /> ㆍ에비텐뿌라 (왕새우튀김)<br /> ㆍ쿠시가츠 (꼬치튀김)<br /> ㆍ야끼우동<br /> ㆍ비프갈릭<br /> ㆍ모듬수제고로케<br /> ㆍ오니기리<br /> ㆍ카라아게 (일본식 닭튀김)<br /> <br /> ※ 메뉴의 가격은 변동이 많아 표기하지 않으므로 방문 문의요망 <br /> 　 메뉴는 음식점 사정에 따라 변동될 수 있으므로 참고 요망
            </treatmenu>

    */
    private String contentid;       // 콘텐츠ID(고유식별번호)
    private String contenttypeid;   // 관광타입(관광지, 숙박 등) ID

    private String tel;             // 전화번호
    private String title;           // 콘텐츠명(제목)

    private String firstimage;      // 원본 대표이미지(약 500*333 size) URL 응답
    private String firstimage2;     // 썸네일 대표이미지(약 150*100 size) URL 응답

    private String areacode;        // 지역코드 (서울특별시는 1)
    private String sigungucode;     // 시군구코드

    private String cat1;            // 대분류 (음식, 레포츠, 숙박 등)
    private String cat2;            // 중분류 (음식점, 수상 레포츠, 숙박시설 등)
    private String cat3;            // 소분류 (한식, 요트, 관광호텔 등)

    private String addr1;           // 주소(예, 서울 중구 다동)
    private String addr2;           // 상세주소
    private String zipcode;         // 우편번호

    private String mapx;            // GPS X좌표(WGS84 경도 좌표)
    private String mapy;            // GPS Y좌표(WGS84 위도 좌표)
    private String mlevel;             // Map level

    private String overview;        // 콘텐츠 개요

    public String getContentid() {
        return contentid;
    }

    public void setContentid(String contentid) {
        this.contentid = contentid;
    }

    public String getContenttypeid() {
        return contenttypeid;
    }

    public void setContenttypeid(String contenttypeid) {
        this.contenttypeid = contenttypeid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstimage() {
        return firstimage;
    }

    public void setFirstimage(String firstimage) {
        this.firstimage = firstimage;
    }

    public String getFirstimage2() {
        return firstimage2;
    }

    public void setFirstimage2(String firstimage2) {
        this.firstimage2 = firstimage2;
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode;
    }

    public String getSigungucode() {
        return sigungucode;
    }

    public void setSigungucode(String sigungucode) {
        this.sigungucode = sigungucode;
    }

    public String getCat1() {
        return cat1;
    }

    public void setCat1(String cat1) {
        this.cat1 = cat1;
    }

    public String getCat2() {
        return cat2;
    }

    public void setCat2(String cat2) {
        this.cat2 = cat2;
    }

    public String getCat3() {
        return cat3;
    }

    public void setCat3(String cat3) {
        this.cat3 = cat3;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public void setAddr2(String addr2) {
        this.addr2 = addr2;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMapx() {
        return mapx;
    }

    public void setMapx(String mapx) {
        this.mapx = mapx;
    }

    public String getMapy() {
        return mapy;
    }

    public void setMapy(String mapy) {
        this.mapy = mapy;
    }

    public String getMlevel() {
        return mlevel;
    }

    public void setMlevel(String mlevel) {
        this.mlevel = mlevel;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
