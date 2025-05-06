const s: string = "MCMXCIV";
console.log(romanToInt(s))

function romanToInt(s: string): number {
    let result: number = 0

    for (let i = 0; i < s.length; i++) {
        switch (s[i]) {

            case 'I' : {
                if (i + 1 <= s.length - 1 && s[i + 1] === 'V') result += 4;
                else if (i + 1 <= s.length - 1 && s[i + 1] === 'X') result += 9;
                else result += 1;
                break
            }
            case 'V': {
                if (i > 0 && s[i - 1] === 'I') continue;
                else result += 5;
                break
            }
            case 'X' : {
                if (i > 0 && s[i - 1] === 'I') continue;
                else if (i + 1 <= s.length - 1 && s[i + 1] === 'L') result += 40;
                else if (i + 1 <= s.length - 1 && s[i + 1] === 'C') result += 90;
                else result += 10;
                break
            }
            case 'L' : {
                if (i > 0 && s[i - 1] === 'X') continue;
                else result += 50;
                break
            }

            case 'C' : {
                if (i > 0 && s[i - 1] === 'X') continue;
                else if (i + 1 <= s.length - 1 && s[i + 1] === 'D') result += 400;
                else if (i + 1 <= s.length - 1 && s[i + 1] === 'M') result += 900;
                else result += 100;
                break
            }

            case 'D' : {
                if (i > 0 && s[i - 1] === 'C') continue;
                else result += 500;
                break
            }

            case 'M' : {
                if (i > 0 && s[i - 1] === 'C') continue;
                else result += 1000;
                break
            }
        }
    }

    return result
}