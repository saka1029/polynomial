# polynomial

## syntax
```
polynomial    = [ '-' ] term { ( '+' | '-' ) term }
term          = power { power }
power         = primary [ '^' digits ]
primary       = variable | digits
variable      = Character.isLetter
digits        = digit { digit }
digit         = '0' .. '9'
```

## power開始条件
```
'a' .. 'z' | 'A' .. 'Z' | '0' .. '9'
```