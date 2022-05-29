package nextstep.ladder.doman;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private final static StringBuilder stringBuilder = new StringBuilder();

    private final List<Point> points = new ArrayList<>();

    public Line(Participants participants, PointConnectStrategy pointConnectStrategy) {
        validate(participants, pointConnectStrategy);
        addPoints(participants, pointConnectStrategy);
    }

    private void validate(Participants participants, PointConnectStrategy pointConnectStrategy) {
        if (participants == null) {
            throw new IllegalArgumentException("참가자는 필수입니다.");
        }
        if (pointConnectStrategy == null) {
            throw new IllegalArgumentException("연결 전략이 없을 수 없습니다.");
        }
    }

    private void addPoints(Participants participants, PointConnectStrategy pointConnectStrategy) {
        addFirstPoint(pointConnectStrategy);
        for (int i = 0; i < participants.getParticipantCount() - 2; i++) {
            PointDirection pointDirection = new PointDirection(points.get(i));
            points.add(new Point(pointDirection, pointConnectStrategy.isConnected()));
        }
        addLastPoint();
    }

    private void addFirstPoint(PointConnectStrategy pointConnectStrategy) {
        points.add(new Point(pointConnectStrategy.isConnected()));
    }

    private void addLastPoint() {
        points.add(new Point(false));
    }

    @Override
    public String toString() {
        stringBuilder.setLength(0);
        stringBuilder.append("   ");
        stringBuilder.append(points.stream().map(Point::toString).collect(Collectors.joining()));
        return stringBuilder.toString();
    }
}
