package com.eomcs.util;

public class ArrayList {
  Object[] list = new Object[5];
  int size = 0;

  // 기능:
  // - 배열에 항목을 추가한다.
  // - 배열이 꽉찼으면 배열의 크기를 늘린다.
  public void add(Object obj) { 
    if (this.size == this.list.length) { //배열이 꽉 찼다면,
      this.list = this.grow(); // 메서드의 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    this.list[this.size++] = obj;
  }

  //기능:
  // - 배열의 크기를 늘린다.
  // - 기존 배열의 값을 복사해온다.
  Object[] grow() {
    Object[] arr = new Object[this.newLength()];
    this.copy(arr);
    return arr;
  }

  //기능:
  // - 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다
  int newLength() {
    return this.list.length + (this.list.length >> 1);
  }

  //기능:
  // - 배열을 복사한다.
  void copy(Object[] target) {
    // 개발자가 잘못 사용할 것을 대비해서 다음 코드를 추가한다.
    // 즉 target 배열이 source 배열보다 작을 경우 target 배열 크기만큼만 복사한다.
    int length = this.list.length;
    if (target.length < this.list.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = this.list[i];
    }
  }

  // 기능:
  // - 배열에 저장된 목록만 꺼내 새 배열에 담아 리턴한
  public Object[] toArray() {
    Object[] arr =  new Object[this.size];
    for (int i=0; i < this.size; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  //기능:
  // -배열에서 지정한 항복을 삭제한다.
  public Object remove(int index) {
    if (index < 0 || index >= this.size) { 
      return null;
    }
    Object old = this.list[index];
    for (int i = index + 1; i < this.size; i++) {
      this.list[i-1] = this.list[i];
    }
    this.size--;
    return old;
  }

  // 기능:
  // - 배열의 특정 위치에 값을 변경한다.
  // - 리턴 값
  // - 변경하기 전에 저장되어 있던 값이다
  public Object set(int index, Object obj) {
    if (index < 0 || index >= this.size) { // 값이 저장된 위치가 무효한 인덱스라면
      return null;
    }
    Object old = this.list[index];
    this.list[index] = obj;
    return old;
  }

  public int size() {
    return this.size;
  }
  public Object get(int index) {
    return this.list[index];
  }
}