const n: number = 8
console.log(fibonacci(n))

function fibonacci(n: number): number {
    if (n === 0 || n === 1) return n
    return fibonacci(n - 1) + fibonacci(n - 2)
}