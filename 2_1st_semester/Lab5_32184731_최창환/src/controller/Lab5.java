// Lab5_32184731_최창환

package controller;

import java.util.List;
import java.util.Set;

import dao.WeatherCalculatorListManager;
import dao.WeatherCalculatorSetManager;
import dto.DewPointCalculator;
import dto.Mode;
import dto.WeatherCalculator;
import dto.WeatherCalculatorFactory;
import dto.WeatherData;

/*
 *  WeatherData 객체를 원소로하는 static weatherData 배열과 Lab 5 프로젝트의 
 *  main 매서드가 포함된 클래스로 주어진 Data와 사용자의 입력을 통한 정보들을
 *  select(), getRandom() 매서드로 특정 생활기상 지수 계산기의 값만을 추출하여 출력하는 클래스.
 */
public class Lab5 {
	// Data of [date, fahrenheitTemperature, relativeHumidity, windVelocity]
	static WeatherData[] weatherData = { 
		new WeatherData("2019-01-01", 30.38, 46, 4.0265),
		new WeatherData("2019-02-01", 33.8, 47, 4.0265),
		new WeatherData("2019-03-01", 44.78, 51, 4.6976),
		new WeatherData("2019-04-01", 53.78, 51, 4.2502),
		new WeatherData("2019-05-01", 66.92, 47, 4.6976),
		new WeatherData("2019-06-01", 72.5, 61, 3.8028),
		new WeatherData("2019-07-01", 78.62, 69, 4.0265),
		new WeatherData("2019-08-01", 80.96, 69, 3.5791),
		new WeatherData("2019-09-01", 72.68, 65, 4.9213),
		new WeatherData("2019-10-01", 61.52, 62, 4.6976),
		new WeatherData("2019-11-01", 45.68, 56, 4.9213),
		new WeatherData("2019-12-01", 34.52, 58, 4.6976),		
		new WeatherData("2020-01-01", 34.88, 56, 4.6976),
		new WeatherData("2020-02-01", 36.5, 58, 5.1450),
		new WeatherData("2020-03-01", 45.86, 46, 5.5924),
		new WeatherData("2020-04-01", 51.98, 50, 6.7108),
		new WeatherData("2020-05-01", 64.4, 67, 5.3687),
		new WeatherData("2020-06-01", 75.02, 68, 5.1450),
		new WeatherData("2020-07-01", 75.38, 77, 5.3687),
		new WeatherData("2020-08-01", 79.7, 85, 5.1450),
		new WeatherData("2020-09-01", 70.52, 71, 5.5924),
		new WeatherData("2020-10-01", 57.74, 61, 4.6976),
		new WeatherData("2020-11-01", 46.4, 64, 4.9213),
		new WeatherData("2020-12-01", 31.46, 58, 4.9213)
	};

	public static void main(String[] args) {
		
		System.out.println("weather data ..");
		WeatherCalculatorListManager listManager = new WeatherCalculatorListManager();

		/*
		 *  중첩 for문을 사용해 WeatherData 배열의 각 객체를 생성자의 매개변수로 하는 5가지
		 *  각각의 생활 기상(이슬점 온도 등)Mode에 대한 클래스의 객체를 listManaer 객체의 
		 *  인스턴스 리스트의 원소로 추가한다.
		 */
		for (WeatherData data : weatherData) {

			for (Mode mode : Mode.values()) {
				WeatherCalculator calculator = WeatherCalculatorFactory.getInstance(mode, data);
				listManager.add(calculator);
			}

		}

		// listManager print_
		// print() 매소드를 통해 listManager 객체의 인스턴스 리스트의 원소 객체들을 각각 출력.
		System.out.println("listManager print..");
		listManager.print();

		/*
		 * resultManager print_
		 *  select() 매소드를 통해 listManager의 인스턴스 리스트의 원소 객체 중에서
		 *  DewPointCalculator 객체인 것만 resultList 리스트에 원소로 추가.
		 */
		List<WeatherCalculator> resultList = listManager.select(e -> e instanceof DewPointCalculator);
		
		System.out.println("\nresultList print..");
		resultList.forEach(System.out::println); // 람다식과 forEach문을 이용한 resultList 모든 원소 출력. 
		
		// getRandom() 매소드를 통해 resultList의 원소 객체 중에서 무작위로 하나의 객체를 randomCalculator(참조 변수)에 대입.
		WeatherCalculator randomCalculator = WeatherCalculatorListManager.getRandom(resultList);
		
		// randomCalculator 출력.
		System.out.println("\nrandomCalculator (from resultList)=" + randomCalculator);
	
		
		// calculate, using user input
		System.out.println("\nuser input..");
		WeatherCalculatorSetManager setManager = new WeatherCalculatorSetManager(); // Set 객체를 생성.

		/*
		 * 사용자에게 mode 정보를 입력받은 후 process() 매소드를 통해 해당 Mode의 Table을 출력하고,
		 * 각 mode에서 필요한 정보(temperature 등)를 입력 받아 결과값을 출력하고 setManager Set에 넣는 것을
		 * q-key 를 입력 받을때까지 반복.
		 */
		do {
			System.out.print("Please enter mode [1: DP, 2: WCT, 3: HI, 4: DI, 5: SI]: ");
			int mode = UserInput.getIntegerBetween(1, 5);
			
			WeatherCalculator calculator = WeatherCalculatorFactory.getInstance(Mode.valueOf(mode));
			calculator.process(); // Table 출력, 사용자 입력, 객체 정보 출력 실행.
			setManager.add(calculator); // 집합에 추가.
			
		} while (!UserInput.getExitKey());

		// print() 매소드를 통해 setManager의 원소들을 출력.
		System.out.println("\nsetManager print..");
		setManager.print();

		/*
		 * resultSet print_
		 *  select() 매소드를 통해 setManager 집합(Set) 원소 객체 중에서
		 *  DewPointCalculator 객체인 것만 resultSet 집합(Set)에 원소로 추가.
		 *  만약, DewPointCalculator 객체가 없다면 resultSet은 원소가 하나도 없는 집합이 됨.
		 */
		Set<WeatherCalculator> resultSet = setManager.select(e -> e instanceof DewPointCalculator);
		
		System.out.println("\nresultSet print..");
		resultSet.forEach(System.out::println); // 람다식과 forEach문을 이용한 resultSet의 모든 원소 출력.
		
		/*
		 *  getRandom() 매소드를 통해 resultSet의 원소 객체 중에서 무작위로 하나의 객체를 
		 *  randomCalculator(참조 변수)에 대입. 만약, resultSet의 원소가 하나도 없다면 null 값이 들어감.
		 */
		randomCalculator = WeatherCalculatorSetManager.getRandom(resultSet);

		//reandomCalculator가 null 값인지 아닌지에 따라 다르게 출력. null 값이 아니면 해당 객체 출력.
		if (randomCalculator == null)
			System.out.print("\nDewPointCalculator가 없습니다.");
		else
			System.out.println("\nrandomCalculator (from resultSet)=" + randomCalculator);

		System.out.println("done..");
	}
}
