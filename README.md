# twiddle-parameter-optimizing
🎈 Twiddle Algorithm for optimizing Parameters of an Algorithm

## Algorithm
Twiddle is an algorithm for finding the optimal parameters, i.e. finding the minimum of the loss function. However, it should not be used for models with maaany parameters :( 🍭 On the other hand, especially for optimization problems where we do not know how the algorithm actually works, it can be very useful. As a consequence, you can take any algorithm requiring parameters (floating point numbers) and use the twiddle algorithm to optimize its parameters. In theory, it could also be applied to neural nets. However, since neural nets have maaaany parameters, this is usually an impossible challenge for twiddle.
<br>Details: https://martin-thoma.com/twiddle/

## Example
I implemented the linear model:

```
y = a*x + b where the (a,b) are parameters
```

I gave the twiddle algorithm training data that corresponds to the linear model

```
y = -2*x + 5 where the (-2,5) are parameters
```

The twiddle algorithm outputs:

```
optimized parameters: [-1.999997996227152, 4.999999155509329]
```

which is close to (-2,5).
