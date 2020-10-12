This document is used to keep track of changes that will need to make to improve the codes in the future (Technical Debt).

Put "[/]" if the item has been resolved

1. EcoPoint feature
- [] FeedingAction is dependent on Hay and Fruit unnecessary. Try to think of better method.

2. Buying items feature

- getAction in BuyingBehaviour is redundant (returns null anyhow)
- VendingMachine has ArrayList and HashMap (which can be redundant)
- Change values based on the assignment 

3. Duplicated code
- Duplicated code in FollowBehaviour and EatFoodBehaviour[/]
- Duplicated code in dinosaur and baby dinosaur

4. Breeding
- Dinosaurs are able to interbreed for now (will change in the future)

5. Spawn grass 
- Spawn too much, try to reduce probability 

6. Error codes
- MoveToFoodBehaviour nullpointer[/]
- FollowBehaviour nullpointer[/]

7. Feeding
- Dinosaur food level does not increase after being fed

