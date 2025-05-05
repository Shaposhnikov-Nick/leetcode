const x = 121
console.log(isPalindrome(x))

function isPalindrome(x) {
    if (x < 0) return false
    const digits = []

    while (x > 0) {
        const digit = x % 10
        digits.push(digit)
        x = Math.floor(x / 10)
    }

    for (let i = 0; i < digits.length / 2; i++) {
        if (digits[i] !== digits[digits.length - 1 - i]) return false
    }

    return true
}