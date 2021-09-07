// Lab5_32184731_최창환

package dto;

/*
 * WeatherCalculator의 명세서로써 구현하는 Interface로
 *  각 생활기상 지수 Table 출력, 사용자에게 입력, 각 생활기상 지수를 계산하는 추상 매서드를 명시.
 */

public interface IWeatherCalculator {
	void printTable(); // 추상메소드
	void getUserInput(); // 추상메소드
	void calculate(); // 추상메소드

}
