const s = "-1d"
console.log(myAtoi(s))


function myAtoi(s) {
    const trimmed = s.trim();
    if (trimmed.length === 0) return 0;

    let sign = 1;
    let startIndex = 0;

    if (trimmed[0] === '-') {
        sign = -1;
        startIndex = 1;
    } else if (trimmed[0] === '+') {
        startIndex = 1;
    }

    let digits = '';
    for (let i = startIndex; i < trimmed.length; i++) {
        const ch = trimmed[i];
        if (ch >= '0' && ch <= '9') {
            digits += ch;
        } else {
            break;
        }
    }

    if (digits.length === 0) return 0;

    const number = sign * Number(digits);

    if (number > 2147483647) return 2147483647;
    if (number < -2147483648) return -2147483648;

    return number;
};