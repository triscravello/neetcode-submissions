class Solution {
    /**
     * @param {string[]} strs
     * @returns {string}
     */
    encode(strs) {
        let encodedString = "";
        for (let str of strs) {
            encodedString += str.length + "#" + str;
        }

        return encodedString;
    }

    /**
     * @param {string} str
     * @returns {string[]}
     */
    decode(str) {
        const decodedStrings = [];
        let i = 0;

        while (i < str.length) {
            let j = str.indexOf("#", i);

            let length = parseInt(str.substring(i, j), 10);

            i = j + 1;

            let string = str.substring (i, i + length);
            decodedStrings.push(string);

            i += length;
        }

        return decodedStrings;
    }
}
