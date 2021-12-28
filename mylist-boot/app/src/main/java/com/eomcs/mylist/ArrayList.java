package com.eomcs.mylist;

public class ArrayList {
  static Contact[] contacts = new Contact[5];
  static int size = 0;

  //기능 :
  // - 입력 받은 파라미터 값을 가지고 CSV 형식으로 문자열을 만들어 준다.
  // 기능 :
  // - 이메일로 연락처 정보를 찾는다.
  // - 찾은 연락처의 배열 인덱스를 리턴한다.
  static int indexOf(String email) {
    for (int i=0; i < size; i++) {
      if (contacts[i].email.equals(email)) {
        return i;
      }
    }
    return -1;
  }

  //기능:
  // - 배열의 크기를 늘린다.
  // - 기존 배열의 값을 복사해온다.
  static Contact[] grow() {
    Contact[] arr = new Contact[newLength()];
    copy(contacts, arr);
    return arr;
  }

  //기능:
  // - 주어진 배열에 대해 50% 증가시킨 새 배열의 길이를 알려준다
  static int newLength() {
    return contacts.length + (contacts.length >> 1);
  }

  // 기능:
  // - 배열을 복사한다.
  static void copy(Contact[] source, Contact[] target) {
    // 개발자가 잘못 사용할 것을 대비해서 다음 코드를 추가한다.
    // 즉 target 배열이 source 배열보다 작을 경우 target 배열 크기만큼만 복사한다.
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }

  //기능:
  // -배열에서 지정한 항복을 삭제한다.
  static Contact remove(int index) {
    Contact old = contacts[index];
    for (int i = index + 1; i < size; i++) {
      contacts[i-1] = contacts[i];
    }
    size--;
    return old;
  }

  // 기능:
  // - 배열에 저장된 목록만 꺼내 새 배열에 담아 리턴한
  static Contact[] toArray() {
    Contact[] arr =  new Contact[size];
    for (int i=0; i < size; i++) {
      arr[i] = contacts[i];
    }
    return arr;
  }

  // 기능:
  // - 배열에 항목을 추가한다.
  // - 배열이 꽉찼으면 배열의 크기를 늘린다.
  static void add(Contact contact) { 
    if (size == contacts.length) { //배열이 꽉 찼다면,
      contacts = grow(); // 메서드의 이름에서 해당 코드에 대한 설명을 짐작할 수 있다.
    }
    contacts[size++] = contact;
  }

  // 기능:
  // - 배열의 특정 위치에 값을 변경한다.
  // - 리턴 값
  // - 변경하기 전에 저장되어 있던 값이다
  static Contact set(int index, Contact contact) {
    if (index < 0 || index >= size) { // 값이 저장된 위치가 무효한 인덱스라면
      return null;
    }
    Contact old = contacts[index];
    contacts[index] = contact;
    return old;
  }
}
