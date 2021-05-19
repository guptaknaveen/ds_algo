package com.s2p.practice.leetcode.problems.robotBoundedCircle;

import java.util.Objects;

public class Solution {

    private enum Direction {
        NORTH, EAST, SOUTH, WEST;
    }

    private enum Move {
        LEFT, RIGHT, GO;
    }

    private class Coordinate {
        int x, y;
        Direction direction;

        Coordinate(Coordinate coordinate) {
            this.x = coordinate.x;
            this.y = coordinate.y;
            this.direction = coordinate.direction;
        }

        Coordinate(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isRobotBounded(String instructions) {

        Coordinate start = new Coordinate(0, 0, Direction.NORTH);
        Coordinate first, second;

        first = findCoordinate(start, instructions);
        second = findCoordinate(first, instructions);

        return first.direction != second.direction || (first.direction == second.direction && first.equals(second));
    }

    private Coordinate findCoordinate(Coordinate start, String instructions) {
        char instruction;

        for (int i = 0;i < instructions.length(); i++) {

            instruction = instructions.charAt(i);

            if (instruction == 'G') {
                start = findCoordinate(start, Move.GO);
                continue;
            }

            if (instruction == 'L') {
                start = findCoordinate(start, Move.LEFT);
                continue;
            }

            if (instruction == 'R') {
                start = findCoordinate(start, Move.RIGHT);
                continue;
            }
        }

        return start;
    }

    private Coordinate findCoordinate(Coordinate coordinate, Move move) {

        Coordinate result = new Coordinate(coordinate);

        if (move == Move.GO) {

            switch (coordinate.direction) {
                case NORTH:
                    result.x = coordinate.x;
                    result.y = coordinate.y + 1;
                    break;

                case EAST:
                    result.x = coordinate.x + 1;
                    result.y = coordinate.y;
                    break;

                case WEST:
                    result.x = coordinate.x - 1;
                    result.y = coordinate.y;
                    break;

                case SOUTH:
                    result.x = coordinate.x;
                    result.y = coordinate.y - 1;
                    break;

                default: break;
            }

            return result;
        }

        switch (coordinate.direction) {

            case NORTH:

                if (move == Move.LEFT) {
                    result.direction = Direction.WEST;
                } else if (move == Move.RIGHT) {
                    result.direction = Direction.EAST;
                }

                break;

            case WEST:

                if (move == Move.LEFT) {
                    result.direction = Direction.SOUTH;
                } else if (move == Move.RIGHT) {
                    result.direction = Direction.NORTH;
                }

                break;

            case SOUTH:

                if (move == Move.LEFT) {
                    result.direction = Direction.EAST;
                } else if (move == Move.RIGHT) {
                    result.direction = Direction.WEST;
                }

                break;

            case EAST:

                if (move == Move.LEFT) {
                    result.direction = Direction.NORTH;
                } else if (move == Move.RIGHT) {
                    result.direction = Direction.SOUTH;
                }

                break;

            default:
                break;

        }


        return result;

    }


    public static void main(String[] args) {
        System.out.println(new Solution().isRobotBounded("GGLLGG"));
        System.out.println(new Solution().isRobotBounded("GL"));
        System.out.println(new Solution().isRobotBounded("GG"));
    }
}