const nums = [2, 7, 11, 15]
const target = 9
console.log(twoSum(nums, target))

/**
 * O(n)
 */
function twoSum(nums, target) {
    const numsMap = new Map()

    for (let i = 0; i < nums.length; i++) {
        const find = target - nums[i]
        if (numsMap.has(find)) {
            return [numsMap.get(find), i]
        }
        numsMap.set(nums[i], i)
    }

    return []
}


