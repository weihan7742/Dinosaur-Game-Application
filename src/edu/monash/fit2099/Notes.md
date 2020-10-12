This document is used to keep track of changes that will need to make to improve the codes in the future (Technical Debt).

Put "[/]" if the item has been resolved

1. EcoPoint feature
- [] FeedingAction is dependent on Hay and Fruit unnecessary. Try to think of better method.

2. Buying items feature

- getAction in BuyingBehaviour is redundant (returns null anyhow)
- VendingMachine has ArrayList and HashMap (which can be redundant)

3. Duplicated code
- duplicated code in FollowBehaviour and EatFoodBehaviour[/]
- duplicated code in dinosaur and baby dinosaur

4. Breeding
- Dinosaurs are able to interbreed for now (will change in the future)
