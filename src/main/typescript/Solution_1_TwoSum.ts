const nums: number[] = [2, 7, 11, 15]
const target: number = 9
console.log(solution_1_TwoSum(nums, target))

/**
 * O(n)
 */
function solution_1_TwoSum(nums: number[], target: number): number[] {
    const numsMap = new Map<number, number>()

    for (let i = 0; i < nums.length; i++) {
        const find = target - nums[i]
        if (numsMap.has(find)) {
            const index = numsMap.get(find)
            if (index !== undefined) {
                return [index, i]
            }
        }
        numsMap.set(nums[i], i)
    }

    return []
}