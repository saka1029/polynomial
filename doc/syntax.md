# polynomial

## syntax
```
polynomial    = [ '-' ] term { ( '+' | '-' ) term }
term          = power { power }
power         = primary [ '^' digits ]
primary       = variable | digits
```

## power開始条件
```
'a' .. 'z' | 'A' .. 'Z' | '0' .. '9'
```