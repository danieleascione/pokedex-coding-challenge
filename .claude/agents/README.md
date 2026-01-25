# Claude Code Agents

This directory contains specialized Claude Code agents for agentic workflow development.

## Attribution

These agents are sourced from [andlaf-ak/claude-code-agents](https://github.com/andlaf-ak/claude-code-agents) by **Andrea Laforgia**.

## Available Agents

| Agent | Purpose |
|-------|---------|
| `problem-analyst` | Deep problem understanding and analysis before implementation |
| `user-story-writer` | Breaking features into granular, INVEST-compliant user stories |
| `atdd-developer` | Implementing user stories using Acceptance Test Driven Development |

## Usage

These agents are automatically available to Claude Code when working in this project. They form a workflow pipeline:

1. **problem-analyst** - Analyze and understand the problem domain
2. **user-story-writer** - Decompose into implementable user stories
3. **atdd-developer** - Implement stories using Red-Green-Refactor cycle

## Workflow Integration

These agents complement the existing [TDD workflow](../tdd-workflow.md) by adding structured problem analysis and story decomposition phases before implementation begins.