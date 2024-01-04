function solution(arr) {
  let sum = 0;

  for (let i = 0; i < arr.length; i++) {
    sum += arr[i];
  }

  let average = sum / arr.length;
  return average;
}

let arr = [1, 2, 3, 4];
console.log(solution(arr));