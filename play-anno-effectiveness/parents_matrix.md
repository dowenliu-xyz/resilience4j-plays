| sn       | super CA | origin in super  | FB in super | sub CA | origin in sub    | FB in sub | TakeEffectAnno  | FallbackLocation | comment           |
|----------|----------|------------------|-------------|--------|------------------|-----------|-----------------|------------------|-------------------|
| 001      | Yes      | Yes with anno    | Yes         | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 002      | Yes      | Yes with anno    | Yes         | Yes    | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 003      | Yes      | Yes with anno    | No          | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 004      | Yes      | Yes with anno    | No          | Yes    | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| 005      | Yes      | Yes with anno    | Yes         | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 006      | Yes      | Yes with anno    | Yes         | Yes    | Yes without anno | No        | SubClassAnno    | Super            |                   |
| 007      | Yes      | Yes with anno    | No          | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 008      | Yes      | Yes with anno    | No          | Yes    | Yes without anno | No        | SubClassAnno    | None             |                   |
| 009      | Yes      | Yes with anno    | Yes         | Yes    | No               | Yes       | SuperMethodAnno | Sub              |                   |
| 010      | Yes      | Yes with anno    | Yes         | Yes    | No               | No        | SuperMethodAnno | Super            |                   |
| 011      | Yes      | Yes with anno    | No          | Yes    | No               | Yes       | SuperMethodAnno | Sub              |                   |
| 012      | Yes      | Yes with anno    | No          | Yes    | No               | No        | SuperMethodAnno | None             |                   |
| 013      | Yes      | Yes without anno | Yes         | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 014      | Yes      | Yes without anno | Yes         | Yes    | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 015      | Yes      | Yes without anno | No          | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 016      | Yes      | Yes without anno | No          | Yes    | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| 017      | Yes      | Yes without anno | Yes         | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 018      | Yes      | Yes without anno | Yes         | Yes    | Yes without anno | No        | SubClassAnno    | Super            |                   |
| 019      | Yes      | Yes without anno | No          | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 020      | Yes      | Yes without anno | No          | Yes    | Yes without anno | No        | SubClassAnno    | None             |                   |
| 021      | Yes      | Yes without anno | Yes         | Yes    | No               | Yes       | SubClassAnno    | Sub              |                   |
| 022      | Yes      | Yes without anno | Yes         | Yes    | No               | No        | SubClassAnno    | Super            |                   |
| 023      | Yes      | Yes without anno | No          | Yes    | No               | Yes       | SubClassAnno    | Sub              |                   |
| 024      | Yes      | Yes without anno | No          | Yes    | No               | No        | SubClassAnno    | None             |                   |
| 025      | Yes      | No               | Yes         | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 026      | Yes      | No               | Yes         | Yes    | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 027      | Yes      | No               | No          | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 028      | Yes      | No               | No          | Yes    | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| 029      | Yes      | No               | Yes         | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 030      | Yes      | No               | Yes         | Yes    | Yes without anno | No        | SubClassAnno    | Super            |                   |
| 031      | Yes      | No               | No          | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 032      | Yes      | No               | No          | Yes    | Yes without anno | No        | SubClassAnno    | None             |                   |
| ~~033~~  | Yes      | No               | -           | Yes    | No               | -         | -               | -                | no origin method! |
| 034      | Yes      | Yes with anno    | Yes         | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 035      | Yes      | Yes with anno    | Yes         | No     | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 036      | Yes      | Yes with anno    | No          | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 037      | Yes      | Yes with anno    | No          | No     | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| 038      | Yes      | Yes with anno    | Yes         | No     | Yes without anno | Yes       | -               | None             |                   |
| 039      | Yes      | Yes with anno    | Yes         | No     | Yes without anno | No        | -               | None             |                   |
| 040      | Yes      | Yes with anno    | No          | No     | Yes without anno | Yes       | -               | None             |                   |
| 041      | Yes      | Yes with anno    | No          | No     | Yes without anno | No        | -               | None             |                   |
| 042      | Yes      | Yes with anno    | Yes         | No     | No               | Yes       | SuperMethodAnno | Sub              |                   |
| 043      | Yes      | Yes with anno    | Yes         | No     | No               | No        | SuperMethodAnno | Super            |                   |
| 044      | Yes      | Yes with anno    | No          | No     | No               | Yes       | SuperMethodAnno | Sub              |                   |
| 045      | Yes      | Yes with anno    | No          | No     | No               | No        | SuperMethodAnno | None             |                   |
| 046      | Yes      | Yes without anno | Yes         | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 047      | Yes      | Yes without anno | Yes         | No     | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 048      | Yes      | Yes without anno | No          | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 049      | Yes      | Yes without anno | No          | No     | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| 050      | Yes      | Yes without anno | Yes         | No     | Yes without anno | Yes       | -               | None             |                   |
| 051      | Yes      | Yes without anno | Yes         | No     | Yes without anno | No        | -               | None             |                   |
| 052      | Yes      | Yes without anno | No          | No     | Yes without anno | Yes       | -               | None             |                   |
| 053      | Yes      | Yes without anno | No          | No     | Yes without anno | No        | -               | None             |                   |
| 054      | Yes      | Yes without anno | Yes         | No     | No               | Yes       | -               | None             |                   |
| 055      | Yes      | Yes without anno | Yes         | No     | No               | No        | -               | None             |                   |
| 056      | Yes      | Yes without anno | No          | No     | No               | Yes       | -               | None             |                   |
| 057      | Yes      | Yes without anno | No          | No     | No               | No        | -               | None             |                   |
| 058      | Yes      | No               | Yes         | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 059      | Yes      | No               | Yes         | No     | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 060      | Yes      | No               | No          | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 061      | Yes      | No               | No          | No     | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| 062      | Yes      | No               | Yes         | No     | Yes without anno | Yes       | -               | None             |                   |
| 063      | Yes      | No               | Yes         | No     | Yes without anno | No        | -               | None             |                   |
| 064      | Yes      | No               | No          | No     | Yes without anno | Yes       | -               | None             |                   |
| 065      | Yes      | No               | No          | No     | Yes without anno | No        | -               | None             |                   |
| ~~066*~~ | Yes      | No               | -           | No     | No               | -         | -               | -                | no origin method! |
| 067      | No       | Yes with anno    | Yes         | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 068      | No       | Yes with anno    | Yes         | Yes    | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 069      | No       | Yes with anno    | No          | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 070      | No       | Yes with anno    | No          | Yes    | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| 071      | No       | Yes with anno    | Yes         | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 072      | No       | Yes with anno    | Yes         | Yes    | Yes without anno | No        | SubClassAnno    | Super            |                   |
| 073      | No       | Yes with anno    | No          | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 074      | No       | Yes with anno    | No          | Yes    | Yes without anno | No        | SubClassAnno    | None             |                   |
| 075      | No       | Yes with anno    | Yes         | Yes    | No               | Yes       | SuperMethodAnno | Sub              |                   |
| 076      | No       | Yes with anno    | Yes         | Yes    | No               | No        | SuperMethodAnno | Super            |                   |
| 077      | No       | Yes with anno    | No          | Yes    | No               | Yes       | SuperMethodAnno | Sub              |                   |
| 078      | No       | Yes with anno    | No          | Yes    | No               | No        | SuperMethodAnno | None             |                   |
| 079      | No       | Yes without anno | Yes         | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 080      | No       | Yes without anno | Yes         | Yes    | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 081      | No       | Yes without anno | No          | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 082      | No       | Yes without anno | No          | Yes    | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| 083      | No       | Yes without anno | Yes         | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 084      | No       | Yes without anno | Yes         | Yes    | Yes without anno | No        | SubClassAnno    | Super            |                   |
| 085      | No       | Yes without anno | No          | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 086      | No       | Yes without anno | No          | Yes    | Yes without anno | No        | SubClassAnno    | None             |                   |
| 087      | No       | Yes without anno | Yes         | Yes    | No               | Yes       | -               | None             |                   |
| 088      | No       | Yes without anno | Yes         | Yes    | No               | No        | -               | None             |                   |
| 089      | No       | Yes without anno | No          | Yes    | No               | Yes       | -               | None             |                   |
| 090      | No       | Yes without anno | No          | Yes    | No               | No        | -               | None             |                   |
| 091      | No       | No               | Yes         | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 092      | No       | No               | Yes         | Yes    | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 093      | No       | No               | No          | Yes    | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 094      | No       | No               | No          | Yes    | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| 095      | No       | No               | Yes         | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 096      | No       | No               | Yes         | Yes    | Yes without anno | No        | SubClassAnno    | Super            |                   |
| 097      | No       | No               | No          | Yes    | Yes without anno | Yes       | SubClassAnno    | Sub              |                   |
| 098      | No       | No               | No          | Yes    | Yes without anno | No        | SubClassAnno    | None             |                   |
| ~~099*~~ | No       | No               | -           | Yes    | No               | -         | -               | -                | no origin method! |
| 100      | No       | Yes with anno    | Yes         | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 101      | No       | Yes with anno    | Yes         | No     | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 102      | No       | Yes with anno    | No          | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 103      | No       | Yes with anno    | No          | No     | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| 104      | No       | Yes with anno    | Yes         | No     | Yes without anno | Yes       | -               | None             |                   |
| 105      | No       | Yes with anno    | Yes         | No     | Yes without anno | No        | -               | None             |                   |
| 106      | No       | Yes with anno    | No          | No     | Yes without anno | Yes       | -               | None             |                   |
| 107      | No       | Yes with anno    | No          | No     | Yes without anno | No        | -               | None             |                   |
| 108      | No       | Yes with anno    | Yes         | No     | No               | Yes       | SuperMethodAnno | Sub              |                   |
| 109      | No       | Yes with anno    | Yes         | No     | No               | No        | SuperMethodAnno | Super            |                   |
| 110      | No       | Yes with anno    | No          | No     | No               | Yes       | SuperMethodAnno | Sub              |                   |
| 111      | No       | Yes with anno    | No          | No     | No               | No        | SuperMethodAnno | None             |                   |
| 112      | No       | Yes without anno | Yes         | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 113      | No       | Yes without anno | Yes         | No     | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 114      | No       | Yes without anno | No          | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 115      | No       | Yes without anno | No          | No     | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| ~~116*~~ | No       | Yes without anno | -           | No     | Yes without anno | -         | -               | -                | no anno!          |
| ~~117*~~ | No       | Yes without anno | -           | No     | No               | -         | -               | -                | no anno!          |
| 118      | No       | No               | Yes         | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 119      | No       | No               | Yes         | No     | Yes with anno    | No        | SubMethodAnno   | Super            |                   |
| 120      | No       | No               | No          | No     | Yes with anno    | Yes       | SubMethodAnno   | Sub              |                   |
| 121      | No       | No               | No          | No     | Yes with anno    | No        | SubMethodAnno   | None             |                   |
| ~~122*~~ | No       | No               | -           | No     | Yes without anno | -         | -               | -                | no anno!          |
| ~~123*~~ | No       | No               | -           | No     | No               | -         | -               | -                | no origin method! |
