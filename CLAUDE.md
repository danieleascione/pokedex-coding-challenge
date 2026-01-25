# Pokédex Project

## Build & Test
```bash
./gradlew build      # Build
./gradlew test       # Run tests
```

## Project Structure
- `src/main/kotlin/` - Source code
- `src/test/kotlin/` - Tests
- `gradle/libs.versions.toml` - Dependency versions

## Principles
- **Minimal dependencies**: Do not add dependencies unless strictly required
- **Latest versions**: Always use the latest available version when adding dependencies

## Git Conventions

Use [Conventional Commits](https://www.conventionalcommits.org/):

```
<type>: <description>

[optional body]
```

### Types
- `feat` - New feature
- `fix` - Bug fix
- `docs` - Documentation only
- `refactor` - Code change that neither fixes a bug nor adds a feature
- `test` - Adding or updating tests
- `chore` - Maintenance tasks (build, dependencies, config)

### Examples
```
feat: add Pokemon search endpoint
fix: handle missing sprite URL gracefully
docs: update API usage examples
refactor: extract Pokemon mapper to separate class
test: add integration tests for PokeAPI client
chore: upgrade Kotlin to 2.1.0
```