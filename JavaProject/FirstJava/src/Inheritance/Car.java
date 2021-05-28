package Inheritance;

class Car {
	int gasolinegauge;		
		Car(int gas) {
			this.gasolinegauge = gas;
		}
}

class HybridCar extends Car {
	
	int electronicGauge;
	
		HybridCar(int gas, int eg) {
				super(gas);
				this.electronicGauge = eg;
			}
		HybridCar(int gas) {
			super(gas);
		
		}		
}
class HybridWaterCar extends HybridCar {
	int waterGauge;
		HybridWaterCar(int gg, int eg, int wg) {
				super(gg,eg);
				this.waterGauge = wg;
			}
		HybridWaterCar(int gg, int eg) {
			super(gg,eg);
		
		}
		HybridWaterCar(int gg) {
			super(gg);		
		}

		
		
		public void showCurrentGauge() {
		System.out.println("잔여 가솔린 : " + gasolinegauge);
		System.out.println("잔여 가솔린 : " + electronicGauge);
		System.out.println("잔여 가솔린 : " + waterGauge);
}
		
	public static void main(String[] args) {
	

	}

}
