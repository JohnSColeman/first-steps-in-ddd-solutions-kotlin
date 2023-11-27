# Kotlin Domain Model
Kotlin offers several advantages over Java for domain modelling, more so when the Arrow
functional extensions library is utilised. Kotlin may result in a substantial (40% to 50%) reduction
of boilerplate code vs Java.

## Kotlin and Arrow Features
In this model we utilise the Kotlin capability to represent non-nullable types, this helps to
push null checking out of the domain layer up into the application layer, or better still further 
into the data input layer. That means we can focus purely on implementing higher level business domain validations.

Arrow offers some non-empty types that can also be utilised when we need to force a collection to 
have at least 1 element. Again this helps to push checking up to the application or input layers.

Type aliases can also be used in Kotlin to create type names that better represent the domain, or
just to make the code more elegant. For example when 2 types are closely related in a use case,
we can define them as a new type alias and bind them as a Pair:

```kotlin
typealias SuspectOffenceAdvice = Pair<Suspect, OffenceAdvice>
```

Operator overloading can also be used to produce more elegant code. Here we showcase this,
although it can be well argued to be counter to the DDD ethos. Below for example we can
use the plus operator on the PoliceInvestigationDetails to add a suspect: 

```kotlin
class PoliceInvestigationDetails(val pncId: PNCId, val suspects: NonEmptySet<Suspect>) {

    operator fun plus(suspect: Suspect) = PoliceInvestigationDetails(pncId, suspects + suspect)
}
```
A test is provided for this operator.

Possible usage:
```kotlin
PoliceInvestigationDetails(pncId, nonEmptySetOf(suspect1)) + suspect2 + suspect3
```
Readers may consider `.addSuspect(suspect2).addSuspect(suspect3)` to be preferable, however that approach is certainly
more verbose and imposes a programming language specific idiom upon a more generally understood idiom of addition, so
I think it can be argued either way.

It is also valid syntax to do these:
```kotlin
PoliceInvestigationDetails(pncId, nonEmptySetOf(suspect1, suspect2, suspect3))

PoliceInvestigationDetails(pncId, investigationDetails.suspects + suspect)
```

Companion object `operator fun invoke` along with `private constructor` can be used to implement
alternative constructor factory methods when we do not want to use the primary constructor:
```kotlin
class PreChargeDecisionCase private constructor(val pncId: PNCId, val offenceAdvice: Map<Suspect, OffenceAdvice?>) {
    ...
    companion object {
        operator fun invoke(pncId: PNCId, suspects: NonEmptySet<Suspect>) =
            PreChargeDecisionCase(pncId, suspects.associateWith { null })
    }
}
```
Here we guarantee that the PreChargeDecisionCase always has at least 1 suspect in the offenceAdvice map.

We could use a regular constructor in this case...
```kotlin
    constructor(pncId: PNCId, suspects: NonEmptySet<Suspect>): this(pncId, suspects.associateWith { null })
```
...but the companion object form could allow for the validation of inputs and possible return of an Arrow EitherNel type
(not shown) to encapsulate either the valid new instance or a failure, so this is only to show how we can go in that
direction even though it is not a required feature. This technique can be used to implement a DDD Factory.

Inline classes improve type safety over primitives and reduce heap allocations thus:
```kotlin
@JvmInline
value class PNCId(@JvmField val value: String)
```
The compiler reduces a PNCId to a String primitive at run time making PNCId compile time only syntax.

Note that we have not made use of the Kotlin `data class` type because this implements the copy function that can
circumvent value validation as is often required for a "Entity". However, for a DDD "Value Object", it may be useful
to implement using a data class type, but also be aware of the functioning of the provided equals implementation.

## Functional Programming Concepts
This solution also embraces some key Functional Programming concepts, including:
- immutability (no setters) and data exposure (no getters)
- use of sealed class over enums

We will not make the case for these approaches here because they are already well discussed in the literature.

## Conclusion
The techniques above are aimed at eliminating **illegal runtime states** that are a common source of bugs that add
considerably to the cost of ownership and are detrimental to user and developer experience. They also reduce the
volume of code making it easier to read and maintain.