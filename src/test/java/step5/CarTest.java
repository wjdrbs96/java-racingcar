package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.domain.Car;
import step5.domain.Position;
import step5.domain.RacingGame;
import step5.dto.InputDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차가 잘 움직이는지 테스트")
    @Test
    void moveCar() {
        Car car = new Car("Gyunny");
        car.move(() -> true);
        Position position = new Position(1);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차가 정지해 있는지 테스트")
    @Test
    void stopCar() {
        Car car = new Car("Gyunny");
        car.move(() -> false);
        Position position = new Position(0);
        assertThat(car.getPosition()).isEqualTo(position);
    }

    @DisplayName("자동차가 잘 만들어지는지 테스트")
    @Test
    void createCarTest() {
        InputDto inputDto = new InputDto(Arrays.asList("A", "B", "C"), 5);
        RacingGame racingGame = new RacingGame(inputDto);
        assertThat(inputDto.getCarNameList().size()).isEqualTo(3);
    }

    @DisplayName("우승자를 찾는 테스트")
    @Test
    void findWinners() {
        Car gyunny = new Car("Gyunny", 1);
        Car manki = new Car("Manki", 2);
        Car woody = new Car("Junho", 0);
        List<Car> listCar = Arrays.asList(gyunny, manki, woody);

        RacingGame racingGame = new RacingGame(listCar);
        racingGame.findWinner();
    }
}
