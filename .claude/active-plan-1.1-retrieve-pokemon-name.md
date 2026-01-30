# Feature: Story 1.1 - Retrieve Pokemon Name

## Context
**As a** parent sharing Pokemon facts with my child
**I want to** retrieve a Pokemon's name by searching for it
**So that** I can confirm I'm looking at the correct Pokemon before sharing details

## Acceptance Criteria
- [x] Given a valid Pokemon name, the response includes the Pokemon's name
- [x] The returned name matches the Pokemon that was requested
- [x] The response is in a readable format (JSON)
- [ ] Given a non-existing Pokemon name, return appropriate error

## Test Plan

### Phase 1: Happy Path (DONE)
- [x] `returns name of existing pokemon` - verifies pikachu returns {"name": "pikachu"}

### Phase 2: Unhappy Paths (IN PROGRESS)
- [ ] `returns 404 for non-existing pokemon` - verifies unknown name returns 404 Not Found
- [ ] `returns 400 for empty pokemon name` - verifies empty/blank name is rejected (optional)

## Structural Changes (Tidy First)
- [x] Extract pokemon.info vertical slice
- [x] Create test DSL for cleaner tests

## Notes
- Currently the endpoint returns 200 for any name (no validation)
- Need to decide error response format (JSON body with message?)