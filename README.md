# tenpinbowl


The following is the implementation of tenpin bowling and SQL challenge for the Adobe Technical Challenge, Round 2.
 
 Details on the core logic for ten pin bowling can be found here:
 
 https://en.wikipedia.org/wiki/Ten-pin_bowling
 
# How To Run
 
To run the bowling application, build with maven and run the file called BasicGameDriver in the drivers folder. This will allow you to not only run the score for strikes but also any option of the test bank via its enum.
 
To run the SQL application, build with maven and run the file called sql/DatabaseDriver.
 
# Application Details
 
 The applications contains the following logical structure:
 
 *util/DataParse- the parser that takes the input bowling scores.
 
 *com/TenPinBowling - contains the major methods required for this application including getScore, isFinished, and roll.
 
 *validation/FrameValidation- contains the logic on how a strike and spare are calculated, as well as their respective
 bonuses.
 
 *sql/DatabaseDriver- provides the driver for the SQL challenges, both required and bonus. The H2 database is embedded for ease of usage. All required SQL scripts, both provided and generated are found in the resources folder.
 
 
 ![Java CI with Maven](https://github.com/joelk111/tenpinbowl/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)
