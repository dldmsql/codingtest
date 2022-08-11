# Greedy 알고리즘

## What is Greedy

눈 앞의 이익만 취하고 보는 알고리즘이다.

현재 시점에서 가장 이득이 되어 보이는 해를 선택하는 행위를 반복한다.

대부분 최적해와는 거리가 멀지만, 드물게 최적해가 보장되는 경우가 있다.

## 최적해가 보장되지 않는 예시

* 이진 트리의 최적합 경로 찾기

이진트리에서 각 노드는 양의 가중치를 가진다고 할 때, 

임의의 노드에 이르면 그때 자식에 할당된 가중치가 공개된다.

리프 노드에 이르면 종료한다고 하자.

탐색 과정에서 만난 노드에 있는 가중치의 합을 최대화 하는 문제이다.

```` bash
greedy(T, w[], r){
x = r;
sum = 0;

while( x != leaf ) {
sum += w[x];
x= Math.max(x, child[x]);

}
sum += w[x];
return sum;
}
````

이 경우에는 BFS나 DFS 방식으로 모든 노드를 확인하기 전에는 최적해를 보장할 수 없다.

* 동전 바꾸기

동전의 액수면이 모두 바로 아래 액수면의 배수가 되면 그리디 알고리즘으로 최적해가 보장된다.

하지만, 액수면이 바로 아래 액수면의 배수가 되지 않으면 그리디 알고리즘으로 최적해가 보장되지 않는다.

## 최적해를 보장하는 예시

* 최소 신장 트리 찾기 위한 프림 알고리즘과 크루스칼 알고리즘
* 회의실 배정 문제
  * 종료 시간이 가장 이른 회의순으로 배정한다.
* 동적 선택 문제

## 매트로이드
> 매트로이드 구조를 가지면 그리디 알고리즘으로 최적해가 보장된다.

> 그리디 알고리즘이라고 해서 매트로이드 구조를 가지는 것은 아니다.

유한 집합 S의 부분집합들의 집합인 I 가 다음 성질을 만족하면 매트로이드라 한다.

1. A 가 I에 속하고, B가 A의 부분 집합이면 B는 I에 속한다. ( 상속성 )
> 집합 A가 I에 속하면 A의 모든 부분 집합도 I에 속한다.
2. A,B가 I에 속하고, |A| 가 |B|의 부분집합이면 A와 {x}의 합집합은 I에 속하는 x가 B-A에 속하는 어떤 값이 존재한다. ( 증강성 또는 교환성 )
> 크기가 다른 두 집합 A, B가 I에 속하면, B의 원소이면서 A의 원소가 아닌 것 중에 A에 더해서 I에 속하게 하는 원소가 존재한다.

### 매트로이드 : 숲

그래프 G = ( V, E )

나무
* 그래프의 하위 그래프 중 사이클을 갖지 않는 연결 그래프를 트리라고 부른다.

숲
* 하나 이상의 트리들로 이루어진 집합
* 또는, 사이클을 이루지 않은 간선들의 집합

숲 집합 F ⊆ 2^E 은 매트로이드이다.

G = ( V, E )에서 파생될 수 있는 모든 숲의 집합을 F라 하자. 

F ⊆ 2^E 이다.

G에서 임의의 숲은 간선을 최대 |E| -1 개 가질 수 있고, 이 경우는 단 하나의 트리로 구성된 숲이다.

F는 매트로이드이다.

왜??

F가 상속성과 증강성을 보이고 있기 때문이다.

증명 1. 상속성
> 어떤 숲의 부분집합도 당연히 숲이다.

증명 2. 증강성
> |A| < |B|인 두 숲 A,B가 있다고 하자.
> 
> (|A| : 숲 A를 구성하는 간선의 개수, 즉 숲 A를 구성하는 트리의 개수 > 숲 B를 구성하는 트리의 개수 이다. 간선의 개수와 그에 따른 트리의 개수는 반비례한다. )

A에 속하는 임의의 트리 하나를 T라 하자. T의 정점들을 연결하는 간선 개수는 B가 A보다 적다. 그렇지 않으면, B에 사이클이 생기기 때문이다. 

B의 간선의 개수가 A보다 많으므로, B에는 A의 서로 다른 트리를 연결하는 간선이 적어도 하나 이상 존재하게 된다. 이 간선 중 하나를 A에 더해도 사이클을 만들지 않으므로, 여전히 숲을 이룬다.

[여기](https://dad-rock.tistory.com/673) 참고하면서 공부 중