//�̽��� Table ��� �� �̽��� ����� ���� �Է�, �̽��� ����� ����� ���� Ŭ����
public class DewPointCalculator extends WeatherCalculator{
	private double temperature; // fahrenheit
	private double relativeHumidity; // %
	
	public DewPointCalculator() {
		//��ü ������ �Ķ���͸� ���� ������ default���� 0.0���� �ʱ�ȭ�ϴ� ������
		this(0.0, 0.0);
	}
	
	public DewPointCalculator(double temperature, double relativeHumidity) {
		//��ü ������ �Ķ���ͷ� ��ü�� �ν��Ͻ� ������ �ʱ�ȭ�ϴ� ������
		this.temperature = temperature;
		this.relativeHumidity = relativeHumidity;
		this.value = calculate(temperature, relativeHumidity);
	}

	/*
	 * ������ �ν��Ͻ� ������ ���� ��ȯ, �����ϴ� �޼���.
	 */
	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(double relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public double getValue() {
		return value;
	}

	// ȭ���µ��� �����µ��� ��ȯ�ϴ� static �޼���.
	public static double fromFahrenheitToCelsius(double F) {
        return (F - 32.0) * (5.0 / 9.0);
    }
	
	// �����µ��� ȭ���µ��� ��ȯ�ϴ� static �޼���.
	public static double fromCelsiusToFahrenheit(double C) {
        return ((9.0 / 5.0) * C + 32.0);
    }
	
	//�Ű������� ���� �µ��� ������ ������ �̽����� ����� double������ ��ȯ�ϴ� static �޼���
	public static double calculate(double F, double RH) {
		double T = fromFahrenheitToCelsius(F);
		double value = (243.12*(Math.log(RH/100) + 17.62*T/(243.12+T)))/(17.62 - (Math.log(RH/100) + 17.62*T/(243.12+T)));		
		value = fromCelsiusToFahrenheit(value);
		return Math.round(value*10)/10.0;
	}
		
	@Override
	public void calculate() {
		this.value = calculate(temperature, relativeHumidity);
	}
	
	//�̽��� ���̺��� ����ϴ� �޼���.
	@Override
	public void printTable() {
		int[] humidities = {100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 30, 25, 20, 15, 10};
		int[] fahrenheit = {110, 105, 100, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 32};
		
		System.out.print("F/RH\t100\t95\t90\t85\t80\t75\t70\t65\t60\t55\t50\t45\t40\t35\t30\t25\t20\t15\t10\n");
		
		for (int i = 0; i < fahrenheit.length; i++) {
			System.out.print(fahrenheit[i] + "\t");
			
			for (int j = 0; j < humidities.length; j++) {
				double dpt = calculate(fahrenheit[i], humidities[j]);
				
				if (dpt >= 32) System.out.print(dpt + "\t");
				else System.out.print("\t\t");
			}
			
			System.out.print("\n");
		}
		
	}

	//�̽��� ����� ���� �µ�(F), ������(%) ���� User���� �Է� �޴� �޼���.
	@Override
	public void getUserInput() {
		System.out.println("\n[Calculate DewPoint]");
		System.out.print("Please enter temperature (F): ");
		setTemperature(UserInput.getDouble());
		
		System.out.print("Please enter relative humidity (%): ");
		setRelativeHumidity(UserInput.getDouble());
	}

	@Override
	public String toString() {
		return "DewPointCalculator [temperature=" + temperature + ", relativeHumidity=" + relativeHumidity + ", value="
				+ value + "]";
	}
}
