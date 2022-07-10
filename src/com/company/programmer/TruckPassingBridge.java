package com.company.programmer;

import java.util.LinkedList;
import java.util.Queue;

public class TruckPassingBridge {

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    int sum = 0; // 무게 저장하기 위한 변수
    Queue<Integer> truckInBridge = new LinkedList<>();

    for(Integer i : truck_weights) { // 반복문을 돌면서
      int truck = i; // 순차적으로 트럭을 하나씩 뽑는다.

      while(true) { // 반복문을 돌면서
        if(truckInBridge.isEmpty()) { // 다리 위에 비어 있다면
          truckInBridge.add(truck); // 다리에 트럭을 올린다.
          sum += truck; // 다리 위에 무게 증가
          answer++; // 시간 증가

          break; // 다음 타자 입장을 위해 반복문 탈출
        } else if(truckInBridge.size() == bridge_length) { // 다리 위에 올라간 트럭 수와 다리 최대 길이가 같다면
          sum -= truckInBridge.poll(); // 맨 앞에 있는 트럭은 다리를 다 지나간 것이므로 다리 위에 무게에서 제거하기
        } else { //다른 트럭이 들어갈 수 있는 상태라면
          if( sum + truck <= weight) { // 즉, 현재 다리에 올라갈 트럭과 이미 올라가 있는 트럭들의 무게가 다리가 버틸 수 있는 무게보다 작거나 같다면
            truckInBridge.add(truck); //다리 위에 트럭을 올린다.
            sum += truck; // 다리 위에 무게 증가
            answer++; // 시간 증가
            break; // 다음 타자 입장을 위해 반복문 탈출
          } else { // 현재 올라가려고 대기하는 트럭이 올라가면 다리가 무너진다.
            truckInBridge.add(0); // 시간만 증가하도록 다리 위에는 무게 0인 가상의 트럭이 올라갔다고 하자.
            answer++; // 시간 증가
          }
        }
      }


    }

    return answer + bridge_length; // 지금까지 걸린 시간과 마지막 트럭이 건너는 데 걸린 시간인 다리 길이를 더해준다.
  }
}
