Byte Order Mark is a Unicode non-character, so it will probably render as a rectangle in editors.

The Lint detector checks for `\uFEFF` which is encoded in UTF-8 as 3 bytes: `EF BB BF`. Interestingly the [Unicode standard](http://www.unicode.org/faq/private_use.html#nonchar_codes) says it's `\uFFFE` and explicitly lists the UTF-8 encoding as `EF BF BE`. I believe this to a bug in the dector. See the [range of Unicode characters that defines BOM](http://www.unicode.org/charts/PDF/UFFF0.pdf).

`// REPORT flipped check, FEFF is a valid "whitespace" character`  
There is a zero-width non-breaking space here >﻿<  
There is a byte order mark here >￾<  
See the [Unicode decomposition of the above codepoints](https://apps.timwhitlock.info/unicode/inspect/hex/feff/fffe).

See also [A quick tale about FEFF, an invisible UTF-8 character that wrecked our CSV files](https://medium.freecodecamp.org/a-quick-tale-about-feff-the-invisible-character-cd25cd4630e7) for an interesting story. Note: in this post they mention codepoint `FEFF` being the BOM, which is only true if it's at the beginning of the file, not in the middle.
