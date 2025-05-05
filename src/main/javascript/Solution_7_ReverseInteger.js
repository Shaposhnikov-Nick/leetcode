const x = 123
console.log(reverse(x))

function reverse(x) {
    let result = 0;
    while (x !== 0) {
        let pop = x % 10;
        x = (x - pop) / 10;
        if (
            result > Math.pow(2, 31) / 10 ||
            (result === Math.pow(2, 31) / 10 && pop > 7)
        )
            return 0;
        if (
            result < Math.pow(-2, 31) / 10 ||
            (result === Math.pow(-2, 31) / 10 && pop < -8)
        )
            return 0;
        result = result * 10 + pop;
    }
    return result;
}