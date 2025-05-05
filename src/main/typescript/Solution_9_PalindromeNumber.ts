const num: number = 121
console.log(isPalindrome(num))

function isPalindrome(x: number) {
    if (x < 0) return false
    const digits: number[] = []

    while (x > 0) {
        const digit: number = x % 10
        digits.push(digit)
        x = Math.floor(x / 10)
    }

    for (let i = 0; i < digits.length / 2; i++) {
        if (digits[i] !== digits[digits.length - 1 - i]) return false
    }

    return true
}